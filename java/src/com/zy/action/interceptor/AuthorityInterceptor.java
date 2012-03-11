package com.zy.action.interceptor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.zy.Constants;
import com.zy.common.model.ZyFriendgroup;
import com.zy.common.model.ZyProfile;
import com.zy.common.util.ActionUtil;
import com.zy.common.util.CookieUtil;
import com.zy.facade.ProfileFacade;
import com.zy.facade.SNSFacade;

public class AuthorityInterceptor extends AbstractInterceptor {
	public static final String GOING_TO_URL_KEY = "GOING_TO";

	private ProfileFacade profileFacade;
	private SNSFacade snsFacade;

	public SNSFacade getSnsFacade() {
		return snsFacade;
	}

	public void setSnsFacade(SNSFacade snsFacade) {
		this.snsFacade = snsFacade;
	}

	public ProfileFacade getProfileFacade() {
		return profileFacade;
	}

	public void setProfileFacade(ProfileFacade profileFacade) {
		this.profileFacade = profileFacade;
	}

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> session = actionContext.getSession();
		if (request.getRequestURI().indexOf("listPeopleYouMayKnow") < 0
				&& request.getRequestURI().indexOf("getNoticeAjax") < 0&&request.getRequestURI().indexOf(".jhtml")>0) {
			String[] menuSelect = new String[10];
			for (int i = 0; i < 10; i++) {
				menuSelect[i] = "";
			}
			// System.out.println("-------------------into
			// menu-----------"+request.getQueryString()+"----------"+request.getRequestURI());

			try {
				// throw new Exception();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

			if (request.getRequestURI().indexOf("landing") > 0) {
				menuSelect[0] = "selectedItem open";
			}

			if (request.getRequestURI().indexOf("feed.jhtml") > 0) {
				if (request.getParameter("handle") == null) {
					menuSelect[1] = "selectedItem open";
				}
				if ("sns.event.create,sns.event.join".equals(request
						.getParameter("handle"))) {
					menuSelect[1] = "selectedItem open";
				}
				if ("sns.share.connection".equals(request
						.getParameter("handle"))) {
					menuSelect[1] = "selectedItem open";
				}

			}
			if (request.getRequestURI().indexOf("message") > 0) {
				menuSelect[2] = "selectedItem open";
			}
			if (request.getRequestURI().indexOf("Invite") > 0) {
				menuSelect[3] = "selectedItem open";
			}
			if (request.getRequestURI().indexOf("getFriends") > 0
					&& request.getRequestURI().indexOf("getFriendsEvents") < 0) {
				menuSelect[4] = "selectedItem open";
			}
			if (request.getRequestURI().indexOf("getMyEvents") > 0) {
				menuSelect[5] = "selectedItem open";
			}
			if (request.getRequestURI().indexOf("getPubEvents") > 0) {
				menuSelect[6] = "selectedItem open";
			}
			if (request.getRequestURI().indexOf("match") > 0) {
				menuSelect[7] = "selectedItem open";
			}
			if ("sns.publish.photo,sns.event.photo".equalsIgnoreCase(request
					.getParameter("handle"))) {
				menuSelect[8] = "selectedItem open";
			}

			if ("sns.publish.question".equalsIgnoreCase(request
					.getParameter("handle"))) {
				menuSelect[9] = "selectedItem open";
			}

			session.put("menuSelect", menuSelect);

			session.remove("cssflag");
			try{
				System.out.println("--------requset.uri--"+request.getRequestURI());
				throw new Exception();
			}catch(Exception ex){
				ex.printStackTrace();
			}
			if (request.getRequestURI().indexOf("newFrdGrp") > 0) {
				System.out.println("-------------put cssflag-------");
				session.put("cssflag", "1");
			}
			if (request.getRequestURI().indexOf("Group") > 0) {
				session.put("cssflag", "1");
			}
			if (request.getRequestURI().indexOf("search") > 0) {
				session.put("cssflag", "1");
			}
			if (request.getRequestURI().indexOf("Search") > 0) {
				session.put("cssflag", "1");
			}

		}

		if (session != null && session.get(Constants.USER_SESSION_KEY) != null) {
			ZyProfile user = (ZyProfile) session
					.get(Constants.USER_SESSION_KEY);
			session.put("snsgroups", snsFacade
					.getFriendGroups(user.getUserid()));

			if (request.getRequestURI().indexOf("getFeedsOfGroup") > 0) {
				int groupId = Integer.valueOf(request.getParameter("groupId"));
				List<ZyFriendgroup> groups = (List<ZyFriendgroup>) session
						.get("snsgroups");
				for (int i = 0; i < groups.size(); i++) {
					if (groups.get(i).getId() == groupId) {
						groups.get(i).setSelected("selectedItem open");
						break;
					}
				}
			}

			return invocation.invoke();
		} else {
			setGoingToURL(session, invocation);
			String value = CookieUtil.getCookie(request);
			if (StringUtils.isNotBlank(value)) {
				System.out.println("------------collectcookie-----------");
				String[] split = value.split(",");
				String email = split[0];
				String password = split[1];

				ZyProfile user = profileFacade.checkProfileLogin(email,
						password);

				if (user != null) {
					if (user.getAvatar() == null
							|| user.getAvatar().equalsIgnoreCase(
									"/images/DEFAULT.JPG")
							|| user.getAvatar().equalsIgnoreCase(
									"//images/DEFAULT.JPG")) {
						ActionContext.getContext().getSession().put("userlogo",
								null);
					} else {
						ActionContext.getContext().getSession().put("userlogo",
								user.getBigavatar());
					}
					ActionContext.getContext().getSession().put(
							Constants.USER_SESSION_KEY, user);
					ActionContext.getContext().getSession().put(
							Constants.USERID_SESSION_KEY, user.getUserid());
					String url = (String) ActionContext.getContext()
							.getSession().get(
									AuthorityInterceptor.GOING_TO_URL_KEY);
					System.out.println("url-------------------" + url);

					ZyProfile user1 = (ZyProfile) session
							.get(Constants.USER_SESSION_KEY);
					session.put("snsgroups", snsFacade.getFriendGroups(user1
							.getUserid()));

					if (request.getRequestURI().indexOf("getFeedsOfGroup") > 0) {
						int groupId = Integer.valueOf(request
								.getParameter("groupId"));
						List<ZyFriendgroup> groups = (List<ZyFriendgroup>) session
								.get("snsgroups");
						for (int i = 0; i < groups.size(); i++) {
							if (groups.get(i).getId() == groupId) {
								groups.get(i).setSelected("selectedItem open");
								break;
							}
						}
					}
					ActionUtil.getResponse().sendRedirect(url);
					return null;
				}
			}
			// setGoingToURL(session, invocation);
			return "to.landing";
		}
	}

	private void setGoingToURL(Map<String, Object> session,
			ActionInvocation invocation) {
		String url = "";
		ActionContext actionContext = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) actionContext
				.get(StrutsStatics.HTTP_REQUEST);
		Map<String, Object> parameters = invocation.getInvocationContext()
				.getParameters();
		Set<String> keys = parameters.keySet();
		String paramlinks = "";
		for (Iterator<String> li = keys.iterator(); li.hasNext();) {
			String key = li.next();
			String[] value = (String[]) parameters.get(key);

			paramlinks = paramlinks + key + "=" + value[0] + "&";
		}
		url = url + request.getRequestURI();
		if (!"".equals(paramlinks)) {
			url = url + "?"
					+ paramlinks.substring(0, paramlinks.lastIndexOf("&"));
		}
		session.put(GOING_TO_URL_KEY, url);
	}

	public void init() {

	}

	public void destroy() {
	}
}

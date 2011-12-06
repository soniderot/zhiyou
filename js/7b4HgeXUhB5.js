﻿
/*1321044080,176820405*/
if (window.CavalryLogger) {
	CavalryLogger.start_js(["Vj2md"]);
}
window.__DEV__ = window.__DEV__ || 0;
if (!window.skipDomainLower && navigator && navigator.userAgent && document.domain.toLowerCase().match(/(^|\.)facebook\..*/) && !(parseInt((/Gecko\/([0-9]+)/.exec(navigator.userAgent) || []).pop(), 10) <= 20060508)) {
	document.domain = window.location.hostname.replace(/^.*(facebook\..*)$/i, "$1");
}
window.onloadhooks = window.onloadhooks || [];
window.onloadRegister = window.onloadRegister || function (a) {
	onloadhooks.push(a);
};
window.onafterloadhooks = window.onafterloadhooks || [];
window.onafterloadRegister = window.onafterloadRegister || function (a) {
	onafterloadhooks.push(a);
};
function run_if_loaded(a, b) {
	return window.loaded && b.call(a);
}
function run_with(b, a, c) {
	Bootloader.loadComponents(a, bind(b, c));
	return false;
}
function wait_for_load(c, b, e) {
	e = bind(c, e, b);
	if (window.loaded) {
		return e();
	}
	switch ((b || event).type) {
	  case "load":
	  case "focus":
		onafterloadRegister(e);
		return;
	  case "click":
		var d = c.style, a = document.body.style;
		d.cursor = a.cursor = "progress";
		onafterloadRegister(function () {
			d.cursor = a.cursor = "";
			if (c.tagName.toLowerCase() == "a") {
				if (false !== e() && c.href) {
					window.location.href = c.href;
				}
			} else {
				if (c.click) {
					c.click();
				}
			}
		});
		break;
	}
	return false;
}
function bind(d, c) {
	var a = Array.prototype.slice.call(arguments, 2);
	function b() {
		var f = d || (this == window ? false : this), e = a.concat(Array.prototype.slice.call(arguments));
		if (typeof (c) == "string") {
			if (f[c]) {
				return f[c].apply(f, e);
			}
		} else {
			return c.apply(f, e);
		}
	}
	b.toString = function () {
		if (typeof (c) == "string") {
			return "bound lazily to \"" + c + "\" on " + d;
		}
		return "bound: " + c;
	};
	return b;
}
var curry = bind(null, bind, null);
function bagofholding() {
}
function bagof(a) {
	return function () {
		return a;
	};
}
function env_get(a) {
	return window.Env && Env[a];
}
if (!Date.now) {
	Date.now = function now() {
		return new Date().getTime();
	};
}
document.documentElement.className = document.documentElement.className.replace("no_js", "");
window.require || (function () {
	var y = {}, v = {}, m = 0, x = this, h = 1, k = 2, i = "special", c = "exports", b = "dependencies", f = "module", l = "waiting", d = "factory", j = undefined, a = "define", e = "global", g = "require";
	function z(zh) {
		var zj = y[zh], zc, zg;
		if (zj[l] && zj[i] & k) {
			p();
		}
		if (!zj[c]) {
			var ze = zj[c] = {}, zf = zj[d];
			if (Object.prototype.toString.call(zf) === "[object Function]") {
				var zb = [], zd = zj[b], zi = zd.length;
				if (zj[i] & k) {
					zi = Math.min(zi, zf.length);
				}
				for (zg = 0; zg < zi; zg++) {
					zc = zd[zg];
					zb.push(zc === f ? zj : (zc === c ? ze : z(zc)));
				}
				var zk = zf.apply(x, zb);
				if (zk) {
					zj[c] = zk;
				}
			} else {
				zj[c] = zf;
			}
		}
		return zj[c];
	}
	function u(ze, zc, zd, zb) {
		if (zc === j) {
			zc = [];
			zd = ze;
			ze = r();
		} else {
			if (zd === j) {
				zd = zc;
				zc = ze;
				ze = r();
			}
		}
		if (y[ze]) {
			return;
		}
		var zf = {id:ze};
		zf[d] = zd;
		zf[b] = zc;
		zf[i] = zb;
		y[ze] = zf;
		n(ze);
	}
	function w(zb, zc) {
		u(zb, zc, j, h);
	}
	function p() {
		var zc = {}, zb;
		for (zb in v) {
			if (y[zb] && !zc[zb] && y[zb][i] & k) {
				q({}, zb, zc);
			}
		}
	}
	function q(ze, zb, zf) {
		zf[zb] = 1;
		var zd = v[zb], zc;
		if (!zd) {
			return;
		}
		ze[zb] = 1;
		for (zc in zd) {
			if (!y[zc][i] & k) {
				continue;
			}
			if (ze[zc]) {
				delete zd[zc];
				y[zc][l]--;
				if (!y[zc][l]) {
					s(zc);
				}
			} else {
				q(ze, zc, zf);
			}
		}
		ze[zb] = 0;
	}
	function r() {
		return "__mod__" + m++;
	}
	function n(zd) {
		var ze = y[zd];
		var zf = 0;
		for (var zc = 0; zc < ze[b].length; zc++) {
			var zb = ze[b][zc];
			if (!y[zb] || y[zb][l]) {
				v[zb] || (v[zb] = {});
				v[zb][zd] = 1;
				zf++;
			}
		}
		ze[l] = zf;
		if (!zf) {
			s(zd);
		}
	}
	function s(zc) {
		var zd = y[zc];
		if (zd[i] & h) {
			z(zc);
		}
		var ze = v[zc];
		if (ze) {
			delete v[zc];
			for (var zb in ze) {
				if (!--y[zb][l]) {
					s(zb);
				}
			}
		}
	}
	function o(zc, zb) {
		y[zc] = {id:zc};
		y[zc][c] = zb;
	}
	o(f, 0);
	o(c, 0);
	o(a, u);
	o(e, x);
	o(g, z);
	u.amd = {};
	x[a] = u;
	x[g] = z;
	z.ensure = w;
	var t = [e, f, g, c];
	var za = false;
	x.__d = function (ze, zc, zd, zb) {
		u(ze, t.concat(zc), zd, zb || k);
		if (y[ze][l] && !za) {
			za = setTimeout(function () {
				p();
				za = false;
			}, 9);
		}
	};
})();
__d("array-utils", [], function (c, e, f, b) {
	function d(g) {
		return (!!g && (typeof g == "object" || typeof g == "function") && ("length" in g) && !("setInterval" in g) && (Object.prototype.toString.call(g) === "[object Array]" || ("callee" in g) || ("item" in g)));
	}
	function a(h) {
		if (!d(h)) {
			return [h];
		}
		if (h.item) {
			var g = h.length, i = new Array(g);
			while (g--) {
				i[g] = h[g];
			}
			return i;
		}
		return Array.prototype.slice.call(h);
	}
	c.hasArrayNature = b.hasArrayNature = d;
	c.$A = b.$A = a;
}, 3);
__d("object-core-utils", [], function (d, f, g, c) {
	function b(i, j) {
		i = i || {};
		j = j || {};
		for (var h in j) {
			i[h] = j[h];
		}
		if (j.hasOwnProperty && j.hasOwnProperty("toString") && (typeof j.toString != "undefined") && (i.toString !== j.toString)) {
			i.toString = j.toString;
		}
		return i;
	}
	function a(h, i) {
		return b(window[h] || (window[h] = {}), i);
	}
	function e(i) {
		if (i instanceof Array) {
			return i.length == 0;
		} else {
			if (i instanceof Object) {
				for (var h in i) {
					return false;
				}
				return true;
			} else {
				return !i;
			}
		}
	}
	d.copy_properties = c.copy_properties = b;
	d.add_properties = c.add_properties = a;
	d.is_empty = c.is_empty = e;
}, 3);
__d("arbiter", ["array-utils", "object-core-utils"], function (f, h, i, e) {
	var c = i("array-utils");
	var g = c.hasArrayNature;
	var a = c.$A;
	var d = i("object-core-utils").copy_properties;
	if (!window.async_callback) {
		window.async_callback = function (j, k) {
			return j;
		};
	}
	function b() {
		d(this, {_listeners:[], _events:{}, _callbacks:{}, _last_id:1, _listen:{}, _index:{}});
		d(this, b);
	}
	d(b, {SUBSCRIBE_NEW:"new", SUBSCRIBE_ALL:"all", BEHAVIOR_EVENT:"event", BEHAVIOR_PERSISTENT:"persistent", BEHAVIOR_STATE:"state", LIVEMESSAGE:"livemessage", BOOTLOAD:"bootload", FUNCTION_EXTENSION:"function_ext", subscribe:function (t, k, r) {
		if (!t || t.length == 0) {
			return null;
		}
		t = a(t);
		var j = b._getInstance(this);
		j._listeners.push({callback:k, types:t});
		var q = j._listeners.length - 1;
		for (var m = 0; m < t.length; m++) {
			if (j._index[t[m]]) {
				j._index[t[m]].push(q);
			} else {
				j._index[t[m]] = [q];
			}
		}
		r = r || b.SUBSCRIBE_ALL;
		if (r == b.SUBSCRIBE_ALL) {
			var l, s, p;
			for (var n = 0; n < t.length; n++) {
				s = t[n];
				if (s in j._events) {
					for (var o = 0; o < j._events[s].length; o++) {
						l = j._events[s][o];
						p = k.apply(null, [s, l]);
						if (p === false) {
							j._events[s].splice(o, 1);
							o--;
						}
					}
				}
			}
		}
		return {subscriberID:q};
	}, unsubscribe:function (n) {
		var j = b._getInstance(this);
		var l = j._listeners[n.subscriberID];
		if (!l) {
			return;
		}
		for (var m = 0; m < l.types.length; m++) {
			var o = l.types[m];
			if (j._index[o]) {
				for (var k = 0; k < j._index[o].length; k++) {
					if (j._index[o][k] == n.subscriberID) {
						j._index[o].splice(k, 1);
						if (j._index[o].length == 0) {
							delete j._index[o];
						}
						break;
					}
				}
			}
		}
		delete j._listeners[n.subscriberID];
	}, inform:function (s, l, k) {
		var v = g(s);
		var u = a(s);
		var j = b._getInstance(this);
		var r = {};
		k = k || b.BEHAVIOR_EVENT;
		for (var n = 0; n < u.length; n++) {
			var s = u[n], m = null;
			if (k == b.BEHAVIOR_PERSISTENT) {
				m = j._events.length;
				if (!(s in j._events)) {
					j._events[s] = [];
				}
				j._events[s].push(l);
				j._events[s]._stateful = false;
			} else {
				if (k == b.BEHAVIOR_STATE) {
					m = 0;
					j._events[s] = [l];
					j._events[s]._stateful = true;
				} else {
					if (s in j._events) {
						j._events[s]._stateful = false;
					}
				}
			}
			window.ArbiterMonitor && ArbiterMonitor.record("event", s, l, j);
			var q;
			if (j._index[s]) {
				var t = a(j._index[s]);
				for (var o = 0; o < t.length; o++) {
					var p = j._listeners[t[o]];
					if (p) {
						q = p.callback.apply(null, [s, l]);
						if (q === false) {
							if (m !== null) {
								j._events[s].splice(m, 1);
							}
							break;
						}
					}
				}
			}
			j._updateCallbacks(s, l);
			window.ArbiterMonitor && ArbiterMonitor.record("done", s, l, j);
			r[s] = q;
		}
		return v ? r : r[u[0]];
	}, query:function (k) {
		var j = b._getInstance(this);
		if (!(k in j._events)) {
			return null;
		}
		if (j._events[k].length) {
			return j._events[k][0];
		}
		return null;
	}, _instance:null, _getInstance:function (j) {
		if (j instanceof b) {
			return j;
		}
		if (!b._instance) {
			b._instance = new b();
		}
		return b._instance;
	}, registerCallback:function (k, m) {
		var q, l = 0, j = b._getInstance(this), p = false;
		if (typeof k == "function") {
			q = j._last_id;
			j._last_id++;
			p = true;
		} else {
			if (!j._callbacks[k]) {
				return null;
			}
			q = k;
		}
		if (g(m)) {
			var r = {};
			for (var o = 0; o < m.length; o++) {
				r[m[o]] = 1;
			}
			m = r;
		}
		for (var s in m) {
			try {
				if (j.query(s)) {
					continue;
				}
			}
			catch (n) {
			}
			l += m[s];
			if (j._listen[s] === undefined) {
				j._listen[s] = {};
			}
			j._listen[s][q] = (j._listen[s][q] || 0) + m[s];
		}
		if (l == 0 && p) {
			k();
			return null;
		}
		if (!p) {
			j._callbacks[q].depnum += l;
		} else {
			j._callbacks[q] = {callback:async_callback(k, "arbiter"), depnum:l};
		}
		return q;
	}, _updateCallbacks:function (m, l) {
		if (l === null || !this._listen[m]) {
			return;
		}
		for (var k in this._listen[m]) {
			this._listen[m][k]--;
			if (this._listen[m][k] <= 0) {
				delete this._listen[m][k];
			}
			this._callbacks[k].depnum--;
			if (this._callbacks[k].depnum <= 0) {
				var j = this._callbacks[k].callback;
				delete this._callbacks[k];
				j();
			}
		}
	}});
	f.Arbiter = h.exports = b;
}, 3);
__d("bootloader", ["arbiter", "array-utils", "object-core-utils"], function (u, w, x, t) {
	var b = x("arbiter");
	var a = x("array-utils").$A;
	var v = x("object-core-utils").is_empty;
	var e = {};
	var j = null;
	var m = {};
	var l = {};
	var g = {};
	var h = {};
	var q = [];
	var k = null;
	var n = {};
	var i = {};
	var f = false;
	var s = [];
	var d = 5000;
	function o() {
		var zb;
		var y = [];
		var zc = Date.now();
		if (zc >= j) {
			if (window.send_error_signal) {
				if (Math.random() < 0.01) {
					send_error_signal("js_timeout_and_exception", "00001:error:CSS timeout.");
				}
			}
			for (zb in e) {
				y.push(zb);
			}
		} else {
			for (zb in e) {
				var zd = e[zb];
				var ze = window.getComputedStyle ? window.getComputedStyle(zd, null) : zd.currentStyle;
				if (ze && parseInt(ze.height, 10) > 1) {
					y.push(zb);
				}
			}
		}
		if (!v(y)) {
			for (var za = 0; za < y.length; za++) {
				var z = e[y[za]];
				z.parentNode.removeChild(z);
				delete e[y[za]];
			}
			j = zc + d;
			c.done(y, true);
		}
		return v(e);
	}
	function p(za) {
		var y = "bootloader_" + za.replace(/[^a-z0-9]/ig, "_");
		var zb = document.createElement("meta");
		zb.id = y;
		c.getHardpoint().appendChild(zb);
		j = Date.now() + d;
		var zc = v(e);
		e[za] = zb;
		if (zc) {
			var z = setInterval(function _poll() {
				if (o()) {
					z && clearInterval(z);
				}
			}, 20, false);
		}
	}
	function r(zb) {
		if (zb in h) {
			var z = h[zb], za = z.link;
			if (za) {
				za.parentNode.removeChild(za);
			} else {
				var zc = q[z.tagIdx];
				for (var y = 0; y < zc.imports.length; y++) {
					if (zc.imports[y].href == z.href) {
						zc.removeImport(y);
						break;
					}
				}
			}
			delete h[zb];
			delete m[zb];
			b.inform(b.BOOTLOAD + "/" + zb, null, b.BEHAVIOR_STATE);
		}
	}
	var c = {configurePage:function (y) {
		var ze = {};
		var zd = c.resolveResources(y);
		var z;
		for (z = 0; z < zd.length; z++) {
			ze[zd[z].src] = zd[z];
			c.requested(zd[z].name);
			p(zd[z].name);
		}
		var zb = document.getElementsByTagName("link");
		for (z = 0; z < zb.length; ++z) {
			if (zb[z].rel != "stylesheet") {
				continue;
			}
			for (var za in ze) {
				if (zb[z].href.indexOf(za) !== -1) {
					var zc = ze[za].name;
					h[zc] = {link:zb[z]};
					if (ze[za].permanent) {
						l[zc] = true;
					}
					delete ze[za];
					break;
				}
			}
		}
	}, loadComponents:function (za, y) {
		if (!f) {
			s.push([za, y]);
			return;
		}
		za = a(za);
		var zd = [];
		for (var zb = 0; zb < za.length; ++zb) {
			if (!za[zb]) {
				continue;
			}
			var z = g[za[zb]];
			if (!!z) {
				for (var zc = 0; zc < z.length; ++zc) {
					zd.push(z[zc]);
				}
			}
		}
		c.loadResources(zd, y);
	}, loadResources:function (zh, z, zg, zk) {
		var zc;
		zh = c.resolveResources(a(zh));
		if (zg) {
			var ze = {};
			for (zc = 0; zc < zh.length; ++zc) {
				ze[zh[zc].name] = true;
			}
			if (!window._retain_bootloaded_resources) {
				for (var zd in m) {
					if (!(zd in l) && !(zd in ze) && !(zd in i)) {
						r(zd);
					}
				}
			}
			i = {};
		}
		var zl = [];
		var zf = [];
		for (zc = 0; zc < zh.length; ++zc) {
			var zi = zh[zc];
			if (zi.permanent) {
				l[zi.name] = true;
			}
			var zj = b.BOOTLOAD + "/" + zi.name;
			if (b.query(zj) !== null) {
				continue;
			}
			if (!zi.nonblocking) {
				zf.push(zj);
			}
			if (!m[zi.name]) {
				c.requested(zi.name);
				zl.push(zi);
				window.CavalryLogger && CavalryLogger.getInstance().measureResources(zi, zk);
			}
		}
		if (z) {
			z = b.registerCallback(z, zf);
		}
		var zb = document.documentMode || +(/MSIE.(\d+)/.exec(navigator.userAgent) || [])[1];
		var za = c.getHardpoint();
		var y = zb ? za : document.createDocumentFragment();
		for (zc = 0; zc < zl.length; ++zc) {
			c._requestResourceIntoHardpoint(zl[zc].type, zl[zc].src, zl[zc].name, y);
		}
		if (za !== y) {
			za.appendChild(y);
		}
		this._logRequestedResources(zl);
		return z;
	}, _logRequestedResources:function (za) {
		var z = JSLogger.create("bootloader");
		for (var y = 0; y < za.length; y++) {
			if (za[y].type === "css") {
				c.loadComponents("uri", function () {
					var zd = "";
					var zb = URI.getNextURI().getPath();
					if (!zb || zb == "/" || zb == "/home.php") {
						zd = "_home";
					} else {
						var zc = zb.indexOf("/", 1);
						if (zc !== -1) {
							zb = zb.substr(0, zc + 1);
						}
						var ze = {"/photo.php":"photo", "/profile.php":"profile", "/permalink.php":"permalink", "/media/set/":"media_set", "/messages/":"messages", "/groups/":"groups"};
						zd = ze[zb] ? "_" + ze[zb] : "";
					}
					if (window._retain_bootloaded_resources) {
						z.bump("requested_css_with_retention" + zd);
					} else {
						z.bump("requested_css_no_retention" + zd);
					}
				});
			}
		}
	}, requestResource:function (zb, za, z) {
		var y = c.getHardpoint();
		c._requestResourceIntoHardpoint(zb, za, z, y);
	}, _requestResourceIntoHardpoint:function (zh, ze, zc, z) {
		if (zh == "js") {
			var zd = document.createElement("script");
			zd.src = ze;
			zd.type = "text/javascript";
			zd.async = true;
			var y = function () {
				c.done([zc]);
			};
			zd.onload = zd.onerror = y;
			zd.onreadystatechange = function () {
				if (this.readyState in {loaded:1, complete:1}) {
					y();
				}
			};
			z.appendChild(zd);
		} else {
			if (zh == "css") {
				if (document.createStyleSheet) {
					var zf = q, zg = -1;
					for (var za = 0; za < zf.length; za++) {
						if (zf[za].imports.length < 25) {
							zg = za;
							break;
						}
					}
					if (zg == -1) {
						zf.push(document.createStyleSheet());
						zg = zf.length - 1;
					}
					zf[zg].addImport(ze);
					h[zc] = {tagIdx:zg, href:ze};
				} else {
					var zb = document.createElement("link");
					zb.rel = "stylesheet";
					zb.type = "text/css";
					zb.media = "all";
					zb.href = ze;
					h[zc] = {link:zb};
					z.appendChild(zb);
				}
				p(zc);
			}
		}
	}, done:function (zc, z) {
		c.requested(zc);
		if (!z) {
			var zb = {sender:this};
			b.inform(b.BOOTLOAD, zb, b.BEHAVIOR_EVENT);
		}
		for (var y = 0; y < zc.length; ++y) {
			var za = zc[y];
			b.inform(b.BOOTLOAD + "/" + za, true, b.BEHAVIOR_STATE);
		}
	}, requested:function (z) {
		z = a(z);
		for (var y = 0; y < z.length; ++y) {
			m[z[y]] = true;
		}
	}, enableBootload:function (z) {
		for (var za in z) {
			if (!g[za]) {
				g[za] = z[za];
			}
		}
		if (!f) {
			f = true;
			for (var y = 0; y < s.length; y++) {
				c.loadComponents.apply(null, s[y]);
			}
			s = [];
		}
	}, getHardpoint:function () {
		if (!k) {
			var y = document.getElementsByTagName("head");
			k = y.length && y[0] || document.body;
		}
		return k;
	}, setResourceMap:function (z) {
		if (!z) {
			return;
		}
		for (var y in z) {
			if (!z[y].name) {
				z[y].name = y;
			}
			n[y] = z[y];
		}
	}, resolveResources:function (zb, y) {
		if (!zb) {
			return [];
		}
		var za = new Array(zb.length);
		for (var z = 0; z < zb.length; ++z) {
			if (!zb[z].type && zb[z] in n) {
				za[z] = n[zb[z]];
				if (y && (y in za[z])) {
					za[z] = za[z][y];
				}
			} else {
				za[z] = zb[z];
			}
		}
		return za;
	}, loadEarlyResources:function (za) {
		var y;
		c.setResourceMap(za);
		var z = [];
		for (y in za) {
			z.push(n[y]);
		}
		c.loadResources(z);
		for (y in za) {
			var zb = n[y];
			if (!zb.permanent) {
				i[zb.name] = zb;
			}
		}
	}, isDisplayJS:function (y) {
		if (typeof y == "string") {
			y = n[y];
		}
		return y.displayjs;
	}};
	u.Bootloader = w.exports = c;
}, 3);
(function () {
	if (window != window.top) {
		return;
	}
	var o = "_e_", q = (window.name || "").toString();
	q = (q.length == 7 && o == q.substr(0, 3)) ? q.substr(3) : (window.name = o + window._EagleEyeSeed).substr(3);
	var m = (window.location.protocol == "https:" && document.cookie.match(/\bcsm=1/)) ? "; secure" : "";
	var k = o + q + "_", g = new Date(+new Date() + 604800000).toGMTString(), e = window.location.hostname.replace(/^.*(facebook\..*)$/i, "$1"), f = "; expires=" + g + ";path=/; domain=" + e + m, d = 0, r = false, l, p = window._EagleEyeSessionStorage && window.sessionStorage, i = document.cookie.length, j = false, n = +new Date();
	function h(v) {
		var s = 2166136261;
		for (var t = 0, u = v.length; t < u; ++t) {
			s = (s ^ v.charCodeAt(t)) * 16777619;
		}
		s += s << 13;
		s ^= s >> 7;
		s += s << 3;
		s ^= s >> 17;
		s += s << 5;
		return (s | 0) + 2147483648;
	}
	function c(s) {
		return k + (d++) + "=" + encodeURIComponent(s) + f;
	}
	function a() {
		var s = [], v = false, u = 0, t = 0;
		this.isEmpty = function () {
			return !s.length;
		};
		this.enqueue = function (x, w) {
			if (w) {
				s.unshift(x);
			} else {
				s.push(x);
			}
		};
		this.dequeue = function () {
			s.shift();
		};
		this.peek = function () {
			return s[0];
		};
		this.clear = function (y) {
			i = Math.min(i, document.cookie.length);
			if (!j && (new Date() - n > 60000)) {
				j = true;
			}
			var w = !y && (document.cookie.search(o) >= 0);
			var zi = !!(window.Env && Env.cookie_header_limit);
			var zd = (window.Env && Env.cookie_count_limit) || 19;
			var ze = (window.Env && Env.cookie_header_limit) || 3950;
			var zb = zd - 5;
			var zc = ze - 1000;
			while (!this.isEmpty()) {
				var x = c(this.peek());
				if (zi && (x.length > ze || (j && x.length + i > ze))) {
					this.dequeue();
					continue;
				}
				if ((w || zi) && ((document.cookie.length + x.length > ze) || (document.cookie.split(";").length > zd))) {
					break;
				}
				document.cookie = x;
				w = true;
				this.dequeue();
			}
			var zf = +new Date();
			if (y || !v && w && ((t > 0) && (Math.min(10 * Math.pow(2, t - 1), 60000) + u < zf)) && (r || window.Arbiter && window.OnloadEvent && Arbiter.query(OnloadEvent.ONLOAD)) && (!this.isEmpty() || (document.cookie.length > zc) || (document.cookie.split(";").length > zb))) {
				var zh = new Image(), zg = this, z = window._EagleEyeDomain || (window.Env && Env.tracking_domain) || "";
				v = true;
				zh.onload = function _EagleEye_logged() {
					v = false;
					t = 0;
					zg.clear();
				};
				zh.onerror = zh.onabort = function _EagleEye_error() {
					v = false;
					u = +new Date();
					t++;
				};
				var za = (window.Env && Env.fb_isb) ? "&fb_isb=" + Env.fb_isb : "";
				var zj = window.Env ? "&__user=" + Env.user : "";
				zh.src = z + "/ajax/nectar.php?asyncSignal=" + (Math.floor(Math.random() * 10000) + 1) + za + zj + "&" + (!y ? "" : "s=") + zf;
			}
		};
	}
	l = new a();
	if (p) {
		var b = function () {
			var u = 0;
			var w = u;
			function t() {
				var y = sessionStorage.getItem("_e_ids");
				if (y) {
					var x = (y + "").split(";");
					if (x.length == 2) {
						u = parseInt(x[0], 10);
						w = parseInt(x[1], 10);
					}
				}
			}
			function v() {
				var x = u + ";" + w;
				sessionStorage.setItem("_e_ids", x);
			}
			function s(x) {
				return "_e_" + ((x !== undefined) ? x : u++);
			}
			this.isEmpty = function () {
				return w === u;
			};
			this.enqueue = function (z, x) {
				var y = x ? s(--w) : s();
				sessionStorage.setItem(y, z);
				v();
			};
			this.dequeue = function () {
				this.isEmpty();
				sessionStorage.removeItem(s(w));
				w++;
				v();
			};
			this.peek = function () {
				var x = sessionStorage.getItem(s(w));
				return x ? (x + "") : x;
			};
			this.clear = l.clear;
			t();
		};
		l = new b();
	}
	window.EagleEye = {log:function (v, s, t) {
		if (window.Env && Env.no_cookies) {
			return;
		}
		var w = [q, +new Date(), v].concat(s);
		w.push(w.length);
		function u() {
			var y = JSON.stringify(w);
			try {
				l.enqueue(y, !!t);
				l.clear(!!t);
			}
			catch (x) {
				if (p && (x.code === 1000)) {
					l = new a();
					p = false;
					u();
				}
			}
		}
		if (window.JSON) {
			u();
		} else {
			if (window.Bootloader) {
				Bootloader.loadComponents("json", u);
			}
		}
	}, createLogger:function (u, s) {
		s = (s === undefined) ? 1 : s;
		var t = function (v, w) {
			if (t.enabled) {
				EagleEye.log(u, v, w);
			}
		};
		t.enabled = false;
		t._key = ((window.Env && Env.user) || Math.random()) + u;
		t.enabled = (h(t._key) % 65535 / 65535) <= s;
		return t;
	}, getSessionID:function () {
		return q;
	}, loaded:function () {
		r = true;
	}};
})();
__d("mixins", ["arbiter"], function (d, e, f, c) {
	var a = f("arbiter");
	var b = {Arbiter:{_getArbiterInstance:function () {
		return this._arbiter || (this._arbiter = new a());
	}, inform:function (i, h, g) {
		return this._getArbiterInstance().inform(i, h, g);
	}, subscribe:function (i, g, h) {
		return this._getArbiterInstance().subscribe(i, g, h);
	}, unsubscribe:function (g) {
		this._getArbiterInstance().unsubscribe(g);
	}}};
	d.Mixins = e.exports = b;
}, 3);
__d("function-extensions", ["array-utils", "arbiter", "mixins", "object-core-utils"], function (k, l, m, j) {
	var a = m("array-utils").$A;
	var b = m("arbiter");
	var d = m("mixins");
	var i = m("object-core-utils").copy_properties;
	Class = {extend:function (n, o) {
		if (!c._arbiterHandle) {
			c._arbiterHandle = b.subscribe(b.BOOTLOAD, c._onbootload.bind(c));
		}
		c._queue(n, o);
	}, mixin:function (p, o) {
		var n = Array.prototype.slice.call(arguments);
		n[0] = n[0].prototype;
		Function.mixin.apply(Function, n);
	}, makeFinal:function (n) {
	}};
	function c() {
	}
	i(c, {_pending:{}, _queue:function (o, p) {
		o.__class_extending = true;
		var n = b.registerCallback(bind(c, c._apply, o, p), [b.FUNCTION_EXTENSION + "/" + p, b.BOOTLOAD]);
		if (n !== null) {
			this._pending[p] = true;
		}
	}, _onbootload:function (o, n) {
		this._update();
	}, _update:function () {
		for (var n in this._pending) {
			if (!!window[n]) {
				delete this._pending[n];
				if (!window[n].__class_extending) {
					b.inform(b.FUNCTION_EXTENSION + "/" + n, true, b.BEHAVIOR_STATE);
				} else {
					window[n].__class_name = n;
				}
			}
		}
	}, _apply:function (n, p) {
		delete n.__class_extending;
		var q = e(window[p], 0);
		var o = e(n, q.prototype.__level + 1);
		o.parent = q;
		if (!!n.__class_name) {
			b.inform(b.FUNCTION_EXTENSION + "/" + n.__class_name, true, b.BEHAVIOR_STATE);
		}
	}});
	function e(p, n) {
		if (p.__metaprototype) {
			return p.__metaprototype;
		}
		var o = new Function();
		o.construct = f;
		o.prototype.construct = h(p, n, true);
		o.prototype.__level = n;
		o.base = p;
		p.prototype.parent = o;
		p.__metaprototype = o;
		return o;
	}
	function f(n) {
		g(n.parent);
		var q = [];
		var p = n;
		while (p.parent) {
			var o = new p.parent();
			q.push(o);
			o.__instance = n;
			p = p.parent;
		}
		n.parent = q[1];
		q.reverse();
		q.pop();
		n.__parents = q;
		n.__instance = n;
		return n.parent.construct.apply(n.parent, arguments);
	}
	function g(q) {
		if (q.initialized) {
			return;
		}
		var n = q.base.prototype;
		if (q.parent) {
			g(q.parent);
			var r = q.parent.prototype;
			for (var o in r) {
				if (o != "__level" && o != "construct" && n[o] === undefined) {
					n[o] = q.prototype[o] = r[o];
				}
			}
		}
		q.initialized = true;
		var p = q.prototype.__level;
		for (var o in n) {
			if (o != "parent") {
				n[o] = q.prototype[o] = h(n[o], p);
			}
		}
	}
	function h(p, o, q) {
		if (typeof p != "function" || p.__prototyped) {
			return p;
		}
		var n = function () {
			var t = this.__instance;
			if (t) {
				var u = t.parent;
				t.parent = o ? t.__parents[o - 1] : null;
				var r = arguments;
				if (q) {
					r = [];
					for (var s = 1; s < arguments.length; s++) {
						r.push(arguments[s]);
					}
				}
				var v = p.apply(t, r);
				t.parent = u;
				return v;
			} else {
				return p.apply(this, arguments);
			}
		};
		n.__prototyped = true;
		return n;
	}
	Function.mixin = function () {
		for (var o = 1, n = arguments.length; o < n; ++o) {
			i(arguments[0], d[arguments[o]] || arguments[o]);
		}
	};
	Function.prototype.bind = function (o) {
		var n = [o, this].concat(Array.prototype.slice.call(arguments, 1));
		return bind.apply(null, n);
	};
	Function.prototype.curry = Function.prototype.bind.bind(null, null);
	Function.prototype.shield = function (o) {
		if (typeof this != "function") {
			throw new TypeException();
		}
		var n = this.bind.apply(this, a(arguments));
		return function () {
			return n();
		};
	};
	Function.prototype.defer = function (o, n) {
		if (typeof this != "function") {
			throw new TypeError();
		}
		o = o || 0;
		return setTimeout(this, o, n);
	};
	k.Class = l.exports = Class;
}, 3);
function set_ue_cookie(a) {
	if (!(window.Env && Env.no_cookies)) {
		document.cookie = "act=" + encodeURIComponent(a) + "; path=/; domain=" + window.location.hostname.replace(/^.*(\.facebook\..*)$/i, "$1");
	}
}
window.UserNoOp = window.UserNoOp || (function () {
	var a = function () {
	};
	var b = function () {
		return this;
	};
	copy_properties(a.prototype, {add_event:b, add_data:b, set_ua_id:b, set_namespace:b});
	return a;
})();
window.UserAction = window.UserAction || (function () {
	var a = function a(e, d, b) {
		var c = e + "/" + d;
		copy_properties(this, {ue:c, _ua_id:null, _ts:e, _ns:null, _start_ts:e, _prev_event:"s", _ue_ts:e, _ue_count:d, _context:b, _version:2});
	};
	a.enable = function (b) {
		a.enable[b] = true;
	};
	a._stack = [];
	copy_properties(a.prototype, {set_ua_id:function (b) {
		this._ua_id = b;
		return this;
	}, set_namespace:function (b) {
		this._ns = b;
		return this;
	}, add_event:function (d) {
		if (!a.enable.events) {
			return this;
		}
		var f = Date.now(), b = f - this._ts;
		var e = f - this._ue_ts;
		var c = [this._version, this.ue, this._ns, this._ua_id, this._prev_event, d, b, e];
		window.EagleEye && EagleEye.log("evt", c);
		this._ts = f;
		this._prev_event = d;
		return this;
	}, add_data:function (b) {
		if (!a.enable.data) {
			return this;
		}
		return this;
	}});
	return a;
})();
window.user_action = window.user_action || (function () {
	var d = 0, c = 0;
	var b = null, a = null;
	return function (e, i, event, h, f) {
		var l = Date.now(), k = l + "/" + d;
		f = f || {};
		if (!i && event) {
			i = event.getTarget();
		}
		var g = 50;
		if (i && b) {
			if (l - c < g && i == b && h != "FORCE") {
				return UserAction._stack[UserAction._stack.length - 1];
			}
		}
		b = i;
		a = event;
		var j = new UserAction(l, d, e);
		UserAction._stack.push(j);
		while (UserAction._stack.length > 10) {
			UserAction._stack.shift();
		}
		Arbiter.inform("UserAction/new", {ua:j, node:i, mode:h, event:event, extra_data:f});
		c = l;
		d++;
		return j;
	};
})();
window.report_data = function (a, b) {
	user_action(a, null, null, "FORCE", b);
};
(function () {
	ClickRef = {};
	ClickRef.get_intern_ref = function (c) {
		if (!!c) {
			var b = {profile_minifeed:1, info_tab:1, gb_content_and_toolbar:1, gb_muffin_area:1, ego:1, bookmarks_menu:1, jewelBoxNotif:1, jewelNotif:1, BeeperBox:1, navSearch:1};
			for (var a = c; a && a != document.body; a = a.parentNode) {
				if (!a.id || typeof a.id !== "string") {
					continue;
				}
				if (a.id.substr(0, 8) == "pagelet_") {
					return a.id.substr(8);
				}
				if (a.id.substr(0, 8) == "box_app_") {
					return a.id;
				}
				if (b[a.id]) {
					return a.id;
				}
			}
		}
		return "-";
	};
	ClickRef.get_href = function (b) {
		var a = (b.getAttribute && (b.getAttribute("ajaxify") || b.getAttribute("data-endpoint")) || b.action || b.href || b.name);
		return a;
	};
	ClickRef.mouse_click_info = function (b) {
		if (!ge("content")) {
			return [0, 0, 0, 0];
		}
		var a = $("content");
		var c = window.Vector2 ? Vector2.getEventPosition(b) : {x:0, y:0};
		return [c.x, c.y, a.offsetLeft, a.clientWidth];
	};
	ClickRef.should_report = function (b, a) {
		if (a == "FORCE") {
			return true;
		}
		if (a == "INDIRECT") {
			return false;
		}
		return (b && ClickRef.get_href(b));
	};
	ClickRef.collect_data = function (l, h, event, d) {
		var j = (!window.ArbiterMonitor) ? "r" : "a", g = [0, 0, 0, 0], k, e, f;
		if (!!event) {
			k = event.type;
			if (k == "click" && ge("content")) {
				g = ClickRef.mouse_click_info(event);
			}
			var b = 0;
			event.ctrlKey && (b += 1);
			event.shiftKey && (b += 2);
			event.altKey && (b += 4);
			event.metaKey && (b += 8);
			if (b) {
				k += b;
			}
		}
		if (!!h) {
			e = ClickRef.get_href(h);
		}
		var a = [];
		if (window.ArbiterMonitor) {
			f = ArbiterMonitor.getInternRef(h);
			a = ArbiterMonitor.getActFields();
		}
		var c = {};
		if (window.collect_data_attribs) {
			c = collect_data_attribs(h, ["ft", "gt"]);
			copy_properties(c.ft, d.ft || {});
			copy_properties(c.gt, d.gt || {});
			if (c.gt.ua_id) {
				l.set_ua_id(c.gt.ua_id);
			}
		}
		var i = [l._ue_ts, l._ue_count, e || "-", l._context, k || "-", f || ClickRef.get_intern_ref(h), j, window.URI ? URI.getRequestURI(true, true).getUnqualifiedURI().toString() : location.pathname + location.search + location.hash, c].concat(g).concat(a);
		return i;
	};
	ClickRef.onNewUserAction = function (b, a) {
		Bootloader.loadComponents("dom-collect", function () {
			if (ClickRef.should_report(a.node, a.mode)) {
				var c = ClickRef.collect_data(a.ua, a.node, a.event, a.extra_data);
				ClickRef.report(a.ua, c);
			}
		});
	};
	ClickRef.report = function (b, a) {
		var c = b.ue;
		set_ue_cookie(c);
		window.EagleEye && EagleEye.log("act", a);
	};
	window.Arbiter && Arbiter.subscribe("UserAction/new", ClickRef.onNewUserAction);
})();
__d("dom-core", [], function (d, e, f, b) {
	var a = function (g) {
		return typeof g == "string" ? document.getElementById(g) : g;
	};
	var c = a;
	d.ge = b.ge = c;
	d.$ = b.$ = a;
}, 3);
__d("css-core", ["dom-core"], function (d, e, f, c) {
	var a = f("dom-core").$;
	var b = {hasClass:function (h, g) {
		h = a(h);
		return (" " + h.className + " ").indexOf(" " + g + " ") > -1;
	}, addClass:function (h, g) {
		h = a(h);
		if (g && !b.hasClass(h, g)) {
			h.className = h.className + " " + g;
		}
		return h;
	}, removeClass:function (h, g) {
		h = a(h);
		if (b.hasClass(h, g)) {
			h.className = h.className.replace(new RegExp("(^|\\s)" + g + "(?:\\s|$)", "g"), "$1");
		}
		return h;
	}, toggleClass:function (h, g) {
		return b.conditionClass(h, g, !b.hasClass(h, g));
	}, conditionClass:function (i, h, g) {
		return (g ? b.addClass : b.removeClass)(i, h);
	}, show:function (g) {
		b.removeClass(g, "hidden_elem");
	}, hide:function (g) {
		b.addClass(g, "hidden_elem");
	}, conditionShow:function (h, g) {
		b.conditionClass(h, "hidden_elem", !g);
	}};
	d.CSS = e.exports = b;
}, 3);
__d("parent", ["css-core"], function (d, e, f, c) {
	var a = f("css-core");
	var b = {byTag:function (g, h) {
		h = h.toUpperCase();
		while (g && g.nodeName != h) {
			g = g.parentNode;
		}
		return g;
	}, byClass:function (h, g) {
		while (h && !a.hasClass(h, g)) {
			h = h.parentNode;
		}
		return h;
	}, byAttribute:function (h, g) {
		while (h && (!h.getAttribute || !h.getAttribute(g))) {
			h = h.parentNode;
		}
		return h;
	}};
	d.Parent = e.exports = b;
}, 3);
__d("referrer-tracker", ["parent"], function (c, d, e, b) {
	var a = e("parent");
	function f(g, k) {
		g = a.byAttribute(g, "data-referrer");
		if (g) {
			var j = /^(?:(?:[^:\/?#]+):)?(?:\/\/(?:[^\/?#]*))?([^?#]*)(?:\?([^#]*))?(?:#(.*))?/.exec(k)[1] || "";
			if (!j) {
				return;
			}
			var i = j + "|" + g.getAttribute("data-referrer");
			var h = new Date();
			h.setTime(Date.now() + 1000);
			document.cookie = "x-src=" + encodeURIComponent(i) + "; " + "expires=" + h.toGMTString() + ";path=/; domain=" + window.location.hostname.replace(/^.*(\.facebook\..*)$/i, "$1");
		}
		return g;
	}
	c.trackReferrer = b.trackReferrer = f;
}, 3);
!function () {
	if (window.__primer) {
		return;
	}
	window.__primer = true;
	var a = null;
	var b = /async(?:-post)?|dialog(?:-pipe|-post)?|theater|toggle/;
	document.documentElement.onclick = function (e) {
		e = e || window.event;
		a = e.target || e.srcElement;
		var f = Parent.byTag(a, "A");
		if (!f) {
			return;
		}
		var c = f.getAttribute("ajaxify");
		var g = f.href;
		var l = c || g;
		if (l) {
			var k = user_action("a", f, e);
			if (window.ArbiterMonitor) {
				ArbiterMonitor.initUA(k, [f]);
			}
		}
		if (c && g && !(/#$/).test(g)) {
			var h = e.which && e.which != 1;
			var i = e.altKey || e.ctrlKey || e.metaKey || e.shiftKey;
			if (h || i) {
				return;
			}
		}
		trackReferrer(f, l);
		var d = ["dialog"];
		var j = f.rel && f.rel.match(b);
		j = j && j[0];
		switch (j) {
		  case "dialog-pipe":
			d.push("ajaxpipe");
		  case "dialog":
		  case "dialog-post":
			Bootloader.loadComponents(d, function () {
				Dialog.bootstrap(l, null, j == "dialog", null, null, f);
			});
			break;
		  case "async":
		  case "async-post":
			Bootloader.loadComponents("async", function () {
				AsyncRequest.bootstrap(l, f);
			});
			break;
		  case "theater":
			Bootloader.loadComponents("PhotoSnowbox", function () {
				PhotoSnowbox.bootstrap(l, f);
			});
			break;
		  case "toggle":
			CSS.toggleClass(f.parentNode, "openToggler");
			Bootloader.loadComponents("Toggler", function () {
				Toggler.bootstrap(f);
			});
			break;
		  default:
			return;
		}
		return false;
	};
	document.documentElement.onsubmit = function (c) {
		c = c || window.event;
		var d = c.target || c.srcElement;
		if (d && d.nodeName == "FORM" && d.getAttribute("rel") == "async") {
			var f = user_action("f", d, c);
			if (window.ArbiterMonitor) {
				ArbiterMonitor.initUA(f, [d]);
			}
			var e = a;
			Bootloader.loadComponents("dom-form", function () {
				Form.bootstrap(d, e);
			});
			return false;
		}
	};
}();
OnloadEvent = {ONLOAD:"onload/onload", ONLOAD_CALLBACK:"onload/onload_callback", ONLOAD_DOMCONTENT:"onload/dom_content_ready", ONLOAD_DOMCONTENT_CALLBACK:"onload/domcontent_callback", ONBEFOREUNLOAD:"onload/beforeunload", ONUNLOAD:"onload/unload"};
function _include_quickling_events_default() {
	return !window.loading_page_chrome;
}
function onbeforeunloadRegister(a, b) {
	if (b === undefined) {
		b = _include_quickling_events_default();
	}
	b ? _addHook("onbeforeleavehooks", a) : _addHook("onbeforeunloadhooks", a);
}
function onunloadRegister(a) {
	if (!window.onunload) {
		window.onunload = function () {
			Arbiter.inform(OnloadEvent.ONUNLOAD, true, Arbiter.BEHAVIOR_STATE);
		};
	}
	_addHook("onunloadhooks", a);
}
function onleaveRegister(a) {
	_addHook("onleavehooks", a);
}
function _addHook(b, a) {
	window[b] = (window[b] || []).concat(a);
}
function removeHook(a) {
	window[a] = [];
}
function _domcontentready() {
	Arbiter.inform(OnloadEvent.ONLOAD_DOMCONTENT, true, Arbiter.BEHAVIOR_STATE);
}
function _bootstrapEventHandlers() {
	var a = document, e = window;
	if (a.addEventListener) {
		var f = /AppleWebKit.(\d+)/.exec(navigator.userAgent);
		if (f && f[1] < 525) {
			var d = setInterval(function () {
				if (/loaded|complete/.test(a.readyState)) {
					_domcontentready();
					clearInterval(d);
				}
			}, 10);
		} else {
			a.addEventListener("DOMContentLoaded", _domcontentready, true);
		}
	} else {
		var c = "javascript:void(0)";
		if (e.location.protocol == "https:") {
			c = "//:";
		}
		a.write("<script onreadystatechange=\"if (this.readyState=='complete') {" + "this.parentNode.removeChild(this);_domcontentready();}\" " + "defer=\"defer\" src=\"" + c + "\"></script>");
	}
	var b = e.onload;
	e.onload = function () {
		e.CavalryLogger && CavalryLogger.getInstance().setTimeStamp("t_layout");
		b && b();
		Arbiter.inform(OnloadEvent.ONLOAD, true, Arbiter.BEHAVIOR_STATE);
	};
	e.onbeforeunload = function () {
		var g = {};
		Arbiter.inform(OnloadEvent.ONBEFOREUNLOAD, g, Arbiter.BEHAVIOR_STATE);
		if (!g.warn) {
			Arbiter.inform("onload/exit", true);
		}
		return g.warn;
	};
}
onload_callback = Arbiter.registerCallback(function () {
	window.CavalryLogger && CavalryLogger.getInstance().setTimeStamp("t_onload");
	Arbiter.inform(OnloadEvent.ONLOAD_CALLBACK, true, Arbiter.BEHAVIOR_STATE);
}, [OnloadEvent.ONLOAD]);
domcontent_callback = Arbiter.registerCallback(function () {
	window.CavalryLogger && CavalryLogger.getInstance().setTimeStamp("t_domcontent");
	Arbiter.inform(OnloadEvent.ONLOAD_DOMCONTENT_CALLBACK, true, Arbiter.BEHAVIOR_STATE);
}, [OnloadEvent.ONLOAD_DOMCONTENT]);
if (!window._eventHandlersBootstrapped) {
	_eventHandlersBootstrapped = true;
	_bootstrapEventHandlers();
}
function tx(b, a) {
	if (typeof _string_table == "undefined") {
		return;
	}
	b = _string_table[b];
	return _tx(b, a);
}
function intl_ends_in_punct(a) {
	if (typeof a != "string") {
		return false;
	}
	return a.match(new RegExp(intl_ends_in_punct.punct_char_class + "[" + ")\"" + "'" + "\xbb" + "\u0f3b" + "\u0f3d" + "\u2019" + "\u201d" + "\u203a" + "\u3009" + "\u300b" + "\u300d" + "\u300f" + "\u3011" + "\u3015" + "\u3017" + "\u3019" + "\u301b" + "\u301e" + "\u301f" + "\ufd3f" + "\uff07" + "\uff09" + "\uff3d" + "s" + "]*$"));
}
intl_ends_in_punct.punct_char_class = "[" + ".!?" + "\u3002" + "\uff01" + "\uff1f" + "\u0964" + "\u2026" + "\u0eaf" + "\u1801" + "\u0e2f" + "\uff0e" + "]";
function intl_render_list_separator() {
	return _tx("{previous-items}\u3001{next-items}", {"previous-items":"", "next-items":""});
}
function intl_phonological_rules(g) {
	var e, d = g, f = window.intl_locale_rewrites, b, c;
	try {
		if (f) {
			var pats = [], reps = [];
			for (var p in f.patterns) {
				var pat = p, rep = f.patterns[p];
				for (b in f.meta) {
					e = new RegExp(b.slice(1, -1), "g");
					pat = pat.replace(e, f.meta[b]);
					rep = rep.replace(e, f.meta[b]);
				}
				pats[pats.length] = pat;
				reps[reps.length] = rep;
			}
			for (var ii = 0; ii < pats.length; ii++) {
				e = new RegExp(pats[ii].slice(1, -1), "g");
				if (reps[ii] == "javascript") {
					c = g.match(e);
					b = c && c[0];
					if (b) {
						g = g.replace(e, b.slice(1).toLowerCase());
					}
				} else {
					g = g.replace(e, reps[ii]);
				}
			}
		}
	}
	catch (a) {
		g = d;
	}
	e = new RegExp("\x01", "g");
	g = g.replace(e, "");
	return g;
}
function _tx(e, a) {
	if (!a) {
		return e;
	}
	var d;
	for (var c in a) {
		if (intl_ends_in_punct(a[c])) {
			d = new RegExp("\\{" + c + "\\}" + intl_ends_in_punct.punct_char_class + "*", "g");
		} else {
			d = new RegExp("\\{" + c + "\\}", "g");
		}
		var b = "\x01";
		e = e.replace(d, b + a[c] + b);
	}
	e = intl_phonological_rules(e);
	return e;
}
InitialJSLoader = {INITIAL_JS_READY:"BOOTLOAD/JSREADY", load:function (a) {
	InitialJSLoader.callback = Bootloader.loadResources(a, InitialJSLoader.callback);
}, callback:Arbiter.registerCallback(function () {
	Arbiter.inform(InitialJSLoader.INITIAL_JS_READY, true, Arbiter.BEHAVIOR_STATE);
}, [OnloadEvent.ONLOAD_DOMCONTENT_CALLBACK])};
__d("prelude-utils", [], function (b, e, f, a) {
	function c(h, g) {
		h = h.toString();
		if (!g && b.PageTransitions && PageTransitions.isInitialized()) {
			PageTransitions.go(h);
		} else {
			if (window.location.href == h) {
				window.location.reload();
			} else {
				window.location.href = h;
			}
		}
	}
	function d(h, j) {
		if (h) {
			for (var i = 0; i < h.length; i++) {
				try {
					(new Function(h[i])).apply(j);
				}
				catch (g) {
				}
			}
		}
	}
	b.goURI = a.goURI = c;
	b.invoke_callbacks = a.invokeCallbacks = d;
}, 3);
window.JSLogger || (function () {
	function b(d) {
		this.cat = d;
		this._counts = {};
	}
	var a = {_JSLogger:b, instances:{}, backlog:[], stringify:function (e) {
		try {
			return JSON.stringify(e);
		}
		catch (d) {
			return "{}";
		}
	}};
	function c(d) {
		b.prototype[d] = function (event, e) {
			if (a.backlog.length < 100) {
				a.backlog.push([this.cat, d, event, e && a.stringify(e), new Date()]);
			}
		};
	}
	c("debug");
	c("log");
	c("warn");
	c("error");
	c("bump");
	c("rate");
	window.JSLogger = {_:a, DUMP_EVENT:"jslogger/dump", create:function (d) {
		return a.instances[d] || (a.instances[d] = new b(d));
	}};
})();
__d("event-form-bubbling", [], function (b, c, d, a) {
	b.Event = b.Event || function () {
	};
	Event.__inlineSubmit = function (f, event) {
		var e = Event.__getHandler && Event.__getHandler(f, "submit");
		return e ? null : Event.__bubbleSubmit(f, event);
	};
	Event.__bubbleSubmit = function (e, event) {
		if (document.documentElement.attachEvent) {
			var f;
			while (f !== false && (e = e.parentNode)) {
				f = e.onsubmit ? e.onsubmit(event) : Event.__fire && Event.__fire(e, "submit", event);
			}
			return f;
		}
	};
}, 3);
window.__c || function () {
	function a(f, c) {
		var e = (typeof c !== "undefined") ? f[c] : f;
		if (Object.prototype.toString.call(e) === "[object Array]") {
			for (var b = 0; b < e.length; b++) {
				a(e, b);
			}
		} else {
			if (typeof e == "object") {
				if (e.__m) {
					f[c] = require(e.__m);
				} else {
					if (e.__e) {
						f[c] = document.getElementById(e.__e);
					} else {
						for (var d in e) {
							a(e, d);
						}
					}
				}
			}
		}
	}
	window.__c = function (e, d, c, b) {
		require.ensure([e].concat(c || []), function (f) {
			b && a(b);
			d && f[d].apply(f, b);
		});
	};
	window.__f = function (d, c, b) {
		define(d, c, function (e) {
			a(b);
			return e.fromJSON.apply(null, b);
		});
	};
}();
JSCC = window.JSCC || function () {
	var a = {}, b = {};
	return {get:function (c) {
		if (c in a) {
			b[c] = a[c]();
			delete a[c];
			return b[c];
		} else {
			return b[c];
		}
	}, init:function (c) {
		copy_properties(a, c);
	}};
}();
DynaTemplate = window.DynaTemplate || (function () {
	var g = "[[", i = "\\[\\[", h = "\\]\\]";
	var l = {};
	var a = {};
	function d(n, m) {
		return m.indexOf(g + n) != -1;
	}
	function e(m) {
		return Object.prototype.toString.call(m) === "[object Array]";
	}
	function f(m) {
		return m && typeof m == "object";
	}
	function c(m) {
		switch (m) {
		  case "&":
			return "&amp;";
		  case "\"":
			return "&quot;";
		  case "'":
			return "&#39;";
		  case "<":
			return "&lt;";
		  case ">":
			return "&gt;";
		  default:
			return m;
		}
	}
	function b(m) {
		m = String(m === null ? "" : m);
		return m.replace(/&(?!\w+;)|["'<>]/g, c);
	}
	function j(n) {
		for (var m in n) {
			var o = n[m];
			a[o[0]] = o[1];
			l[m] = o[1];
		}
	}
	function k(p, m) {
		if (p.charAt(0) == "@") {
			return k(a[p.substring(1)], m);
		}
		if (d("#", p) || d("^", p)) {
			var o = new RegExp(i + "(\\^|\\#)\\s*(.+)\\s*" + h + "\n*([\\s\\S]+?)" + i + "\\/\\s*\\2\\s*" + h + "\\s*", "mg");
			p = p.replace(o, function (q, v, t, r) {
				var w = m[t];
				w = (w && w.__html !== undefined) ? w.__html : w;
				if (v == "^") {
					if (!w || e(w) && w.length === 0) {
						return k(r, m);
					} else {
						return "";
					}
				} else {
					if (v == "#") {
						if (e(w)) {
							var u = [];
							for (var s = 0; s < w.length; s++) {
								u.push(k(r, w[s]));
							}
							return u.join("");
						} else {
							if (f(w)) {
								return k(r, w);
							} else {
								if (!(typeof w == "function")) {
									if (w) {
										return k(r, m);
									}
								}
							}
						}
						return "";
					}
				}
			});
		}
		if (!d("", p)) {
			return p;
		}
		var n = new RegExp(i + "(>|\\[|&)?([^\\/#\\^]+?)\\1?" + h + "+", "g");
		return p.replace(n, function (q, s, r) {
			r = r.replace(/^\s*|\s*$/g, "");
			var t = m[r];
			if (!t || t instanceof Array && t.length === 0) {
				return "";
			}
			switch (s) {
			  case ">":
				if (t[0].charAt(0) == "@") {
					return k(t[0], t[1]);
				} else {
					if (!(t[0] in l)) {
						return "";
					}
				}
				return k(l[t[0]], t[1]);
			  case "&":
			  default:
				if (window.HTML && t instanceof HTML) {
					return t.toString();
				}
				return t.__html !== undefined ? t.__html : b(t);
			}
		});
	}
	return {registerTemplates:j, renderToHtml:k};
})();
__d("big-pipe", ["dom-core", "arbiter", "bootloader"], function (g, i, j, e) {
	var a = j("dom-core").$;
	var f = j("dom-core").ge;
	var b = j("arbiter");
	var d = j("bootloader");
	var h = document.documentMode || +(/MSIE.(\d+)/.exec(navigator.userAgent) || [])[1];
	function c(k) {
		copy_properties(this, {arbiter:b, rootNodeID:"content", lid:0, isAjax:false, rrEnabled:true, domContentCallback:domcontent_callback, onloadCallback:onload_callback, domContentEvt:OnloadEvent.ONLOAD_DOMCONTENT_CALLBACK, onloadEvt:OnloadEvent.ONLOAD_CALLBACK, forceFinish:false, _phaseDoneCallbacks:[], _currentPhase:0, _lastPhase:-1});
		copy_properties(this, k);
		this._cavalry = (this.lid && window.CavalryLogger) ? CavalryLogger.getInstance(this.lid) : null;
		this._inst = this._cavalry && (window._pagelet_profile || this._cavalry.isPageletProfiler());
		c._current_instance = this;
		if (env_get("tti_vision") == 1) {
			(new TTIVisualizer(this)).init();
		}
		this.arbiter.registerCallback(this.domContentCallback, ["pagelet_displayed_all"]);
		this.arbiter.inform("phase_begin_0", true, b.BEHAVIOR_STATE);
		this._inst && this._cavalry.setTimeStamp("t_phase_begin_0");
		this.onloadCallback = this.arbiter.registerCallback(this.onloadCallback, ["pagelet_displayed_all"]);
	}
	copy_properties(c.prototype, {_ct:function (k) {
		return (!k || "length" in k && k.length === 0) ? {} : k;
	}, _displayPageletHandler:function (k) {
		if (this.displayCallback) {
			this.displayCallback(this._displayPagelet.bind(this, k));
		} else {
			this._displayPagelet(k);
		}
	}, _displayPagelet:function (m) {
		if (this._inst) {
			this._cavalry.onPageletEvent("display_start", m.id);
		}
		m.content = this._ct(m.content);
		var l = true;
		for (var p in m.content) {
			var k = m.content[p];
			if (m.append) {
				p = (m.append === "bigpipe_root") ? this.rootNodeID : m.append;
			}
			var o = f(p);
			if (o) {
				k = this._getContentMarkup(k);
				if (k) {
					if (!m.append && m.has_inline_js) {
						if (window.DOM && window.HTML) {
							DOM.setContent(o, HTML(k));
						} else {
							l = false;
							d.loadComponents(["dom", "dom-html"], function () {
								DOM.setContent(o, HTML(k));
								this.arbiter.inform(m.id + "_displayed", true, b.BEHAVIOR_STATE);
							}.bind(this));
						}
					} else {
						if (m.append || h < 8) {
							if (!m.append) {
								while (o.firstChild) {
									o.removeChild(o.firstChild);
								}
							}
							this._appendNodes(o, k);
						} else {
							o.innerHTML = k;
						}
					}
				}
				if (this._inst) {
					this._cavalry.onPageletEvent("display", m.id);
				}
				var n = o.getAttribute("data-referrer");
				if (!n) {
					o.setAttribute("data-referrer", p);
				}
			}
		}
		if (l) {
			this.arbiter.inform(m.id + "_displayed", true, b.BEHAVIOR_STATE);
		}
		if (m.cache_hit && env_get("pc_debug") == 1) {
			a(m.id).style.border = "1px red solid";
		}
	}, _getContentMarkup:function (l) {
		if (!l || typeof l === "string") {
			return l;
		}
		if (l.container_id) {
			var k = a(l.container_id);
			l = this._extractMarkup(k) || "";
			k.parentNode.removeChild(k);
			return l;
		}
		if (l.length >= 2) {
			return DynaTemplate.renderToHtml(l[0], l[1]);
		}
		return null;
	}, _extractMarkup:function (l) {
		if (!l.firstChild) {
			d.loadComponents("error-signal", function () {
				send_error_signal("bigpipe", "Pagelet markup container is empty.");
			});
			return null;
		}
		if (l.firstChild.nodeType !== 8) {
			return null;
		}
		var k = l.firstChild.nodeValue;
		k = k.substring(1, k.length - 1);
		return k.replace(/\\([\s\S]|$)/g, "$1");
	}, _appendNodes:function (k, n) {
		var o = document.createElement("div");
		var m = h < 7;
		if (m) {
			k.appendChild(o);
		}
		o.innerHTML = n;
		var l = document.createDocumentFragment();
		while (o.firstChild) {
			l.appendChild(o.firstChild);
		}
		k.appendChild(l);
		if (m) {
			k.removeChild(o);
		}
	}, _downloadJsForPagelet:function (k) {
		d.loadResources(k.js || [], bind(this, function () {
			if (this._inst) {
				this._cavalry.onPageletEvent("jsdone", k.id);
			}
			k.requires = k.requires || [];
			if (!this.isAjax || k.phase >= 1) {
				k.requires.push("uipage_onload");
			}
			var m = bind(this, function () {
				if (!this._isRelevant()) {
					return;
				}
				invoke_callbacks(k.onload);
				if (k.cacheable && !k.cache_hit) {
					PageletCache.write(k);
				}
				if (this._inst) {
					this._cavalry.onPageletEvent("onload", k.id);
				}
				this.arbiter.inform("pagelet_onload", true, b.BEHAVIOR_EVENT);
				k.provides && this.arbiter.inform(k.provides, true, b.BEHAVIOR_STATE);
			});
			var l = bind(this, function () {
				this._isRelevant() && invoke_callbacks(k.onafterload);
			});
			if (this.delay) {
				var n = m;
				m = function () {
					setTimeout(n, 400);
				};
			}
			this.arbiter.registerCallback(m, k.requires);
			this.arbiter.registerCallback(l, [this.onloadEvt]);
		}), false, k.id);
	}, _downloadCssAndDisplayPagelet:function (m) {
		if (this._inst) {
			this._cavalry.onPageletEvent("css", m.id);
		}
		var l = bind(this, function () {
			var n = m.display_dependency || [];
			var p = [];
			for (var o = 0; o < n.length; o++) {
				p.push(n[o] + "_displayed");
			}
			this.arbiter.registerCallback(this._displayPageletHandler.bind(this, m), p);
		});
		var k = m.css || [];
		d.loadResources(k, l, false, m.id);
		if (this._inst) {
			this._cavalry.onPageletEvent("css_end", m.id);
		}
	}, _downloadAndScheduleDisplayJS:function (n) {
		var m = n.js || [];
		var k = [];
		for (var l = 0; l < m.length; l++) {
			if (d.isDisplayJS(m[l])) {
				k.push(m[l]);
			}
		}
		d.loadResources(k, bind(this, function () {
			if (n.ondisplay && n.ondisplay.length) {
				this.arbiter.registerCallback(function () {
					invoke_callbacks(n.ondisplay);
				}, [n.id + "_displayed"]);
			}
		}));
	}, onPageletArrive:function (k) {
		if (this._inst) {
			this._cavalry.onPageletEvent("arrive", k.id);
		}
		var l = k.phase;
		if (!this._phaseDoneCallbacks[l]) {
			this._phaseDoneCallbacks[l] = this.arbiter.registerCallback(this._onPhaseDone.bind(this), ["phase_complete_" + l]);
		}
		this.arbiter.registerCallback(this._phaseDoneCallbacks[l], [k.id + "_displayed"]);
		if (k.cacheable) {
			if (k.cache_hit) {
				b.registerCallback(function () {
					this.processPagelet(this.loadFromCache(k));
				}.bind(this), ["pagelet_cache_loaded"]);
			} else {
				PageletCache.write(k);
				this.processPagelet(k);
			}
		} else {
			this.processPagelet(k);
		}
		if (this._inst) {
			this._cavalry.onPageletEvent("arrive_end", k.id);
		}
	}, processPagelet:function (l) {
		var m = l.phase;
		if (l.the_end) {
			this._lastPhase = l.phase;
		}
		if (l.tti_phase !== undefined) {
			this._ttiPhase = l.tti_phase;
		}
		l.jscc && invoke_callbacks([l.jscc]);
		l.tplts && DynaTemplate.registerTemplates(l.tplts);
		d.setResourceMap(l.resource_map);
		d.enableBootload(this._ct(l.bootloadable));
		var n = "phase_begin_" + m;
		this.arbiter.registerCallback(this._downloadCssAndDisplayPagelet.bind(this, l), [n]);
		this.arbiter.registerCallback(this._downloadAndScheduleDisplayJS.bind(this, l), [n]);
		var k;
		if (!this.jsNonBlock) {
			k = this.domContentEvt;
		} else {
			k = l.id + "_displayed";
		}
		this.arbiter.registerCallback(this.onloadCallback, ["pagelet_onload"]);
		this.arbiter.registerCallback(this._downloadJsForPagelet.bind(this, l), [k]);
		if (l.jscalls) {
			this.arbiter.registerCallback(function () {
				invoke_callbacks([l.jscalls]);
			}, [l.id + "_displayed"]);
		}
		l.is_last && this.arbiter.inform("phase_complete_" + m, true, b.BEHAVIOR_STATE);
	}, _onPhaseDone:function () {
		if (this._currentPhase === this._ttiPhase && this.rrEnabled) {
			this.arbiter.inform("tti_bigpipe", {s:this.lid}, b.BEHAVIOR_EVENT);
			this._cavalry && this._cavalry.setTTIPhase(this._ttiPhase).measurePageLoad(true);
		}
		var l = this._currentPhase + 1;
		var k = bind(this, function () {
			this._inst && this._cavalry.setTimeStamp("t_phase_begin_" + l);
			this.arbiter.inform("phase_begin_" + l, true, b.BEHAVIOR_STATE);
		});
		if (this._currentPhase === this._lastPhase && this._isRelevant()) {
			this.arbiter.inform("pagelet_displayed_all", true, b.BEHAVIOR_STATE);
		}
		this._currentPhase++;
		if (h) {
			setTimeout(k, 20);
		} else {
			k();
		}
	}, _isRelevant:function () {
		return this == c._current_instance || this.jsNonBlock || this.forceFinish;
	}});
	c.pagelet_ids = {};
	g.BigPipe = i.exports = c;
}, 3);
__d("eval-global", [], function (c, d, e, b) {
	function a(h) {
		if ("string" != typeof (h)) {
			throw new Error("JS sent to eval_global is not a string.  Only strings " + "are permitted.");
		} else {
			if ("" == h) {
				return;
			}
		}
		var i = document.createElement("script");
		i.type = "text/javascript";
		try {
			i.appendChild(document.createTextNode(h));
		}
		catch (f) {
			i.text = h;
		}
		var g = (document.getElementsByTagName("head")[0] || document.documentElement);
		g.appendChild(i);
		g.removeChild(i);
	}
	c.eval_global = b.eval_global = a;
}, 3);
function namespace(e, f) {
	var d = e.split("."), a = 0, b = d.length, c = f || window;
	for (; a < b; a++) {
		if (!c[d[a]]) {
			c[d[a]] = {};
		}
		c = c[d[a]];
	}
	return c;
}
function incorporate_fragment(a) {
	var c = /^(?:(?:[^:\/?#]+):)?(?:\/\/(?:[^\/?#]*))?([^?#]*)(?:\?([^#]*))?(?:#(.*))?/;
	var b = "";
	a.href.replace(c, function (d, g, h, f) {
		var e, i;
		e = i = g + (h ? "?" + h : "");
		if (f) {
			f = f.replace(/^(!|%21)/, "");
			if (f.charAt(0) == "/") {
				e = f.replace(/^\/+/, "/");
			}
		}
		if (e != i) {
			if (window._script_path) {
				document.cookie = "rdir=" + window._script_path + "; path=/; domain=" + window.location.hostname.replace(/^.*(\.facebook\..*)$/i, "$1");
			}
			window.location.replace(b + e);
		}
	});
}
if (window._incorporate_fragment) {
	incorporate_fragment(window.location);
}
!function () {
	var b = document.documentElement;
	var a = function (c) {
		c = c || window.event;
		var d = c.target || c.srcElement;
		var f = d.getAttribute("placeholder");
		if (f) {
			var e = Parent.byClass(d, "focus_target");
			if ("focus" == c.type || "focusin" == c.type) {
				if (d.value == f && CSS.hasClass(d, "DOMControl_placeholder")) {
					d.value = "";
					CSS.removeClass(d, "DOMControl_placeholder");
				}
				if (e) {
					CSS.addClass(e, "child_is_active");
					CSS.addClass(e, "child_is_focused");
					CSS.addClass(e, "child_was_focused");
					Arbiter.inform("reflow");
				}
			} else {
				if (d.value == "") {
					CSS.addClass(d, "DOMControl_placeholder");
					d.value = f;
					e && CSS.removeClass(e, "child_is_active");
					d.style.direction = "";
				}
				e && CSS.removeClass(e, "child_is_focused");
			}
		}
	};
	if (b.addEventListener) {
		b.addEventListener("focus", a, true);
		b.addEventListener("blur", a, true);
	} else {
		b.onfocusin = b.onfocusout = a;
	}
}();
document.documentElement.onkeydown = function (a) {
	a = a || window.event;
	var b = a.target || a.srcElement;
	var c = a.keyCode == 13 && !a.altKey && !a.ctrlKey && !a.metaKey && !a.shiftKey && CSS.hasClass(b, "enter_submit");
	if (c) {
		Bootloader.loadComponents(["dom", "input-methods"], function () {
			if (!Input.isEmpty(b)) {
				var d = DOM.scry(b.form, ".enter_submit_target")[0] || DOM.scry(b.form, "[type=\"submit\"]")[0];
				d && d.click();
			}
		});
		return false;
	}
};
function fc_click(a, b) {
	user_action("ufi", a);
	fc_expand(a, b);
}
function fc_expand(a, b) {
	var c = Parent.byTag(a, "form");
	fc_uncollapse(c);
	CSS.removeClass(c, "hidden_add_comment");
	if (b !== false) {
		(c.add_comment_text_text || c.add_comment_text).focus();
	}
	return false;
}
function fc_uncollapse(a) {
	CSS.removeClass(a, "collapsed_comments");
}


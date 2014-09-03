if (typeof(QZFL) == "undefined" || !QZFL) {
    var QZFL;
    if (typeof(gdcy) == "object") {
        QZFL = gdcy;}
         else {
        window.gdcy = QZFL = {};
    }
    QZFL._qzfl = true;
};

QZFL.userAgent = (function() {
    var t,
    vie,
    vff,
    vopera,
    vsf,
    vawk,
    wintype,
    winver,
    mactype,
    vair,
    vchrome,
    isBeta = false,
    discerned = false,
    _ua = navigator.userAgent,
    mainRE = /(?:MSIE.(\d+\.\d+))|(?:(?:Firefox|GranParadiso|Iceweasel|Minefield).(\d+\.\d+))|(?:Opera.(\d+\.\d+))|(?:AppleWebKit.(\d+(?:\.\d+)?))/,
    osRE = /(Windows.*?;)|(Mac OS X.*?;)/,
    winRE = /Windows.+?(\d+\.\d+)/,
    airRE = /AdobeAIR/,
    chromeRE = /Chrome.(\d+\.\d+)/,
    safariRE = /Version\/(\d+(?:\.\d+)?)/,
    agent = mainRE.exec(_ua),
    os = osRE.exec(_ua);
    if (agent) {
        vie = agent[1] ? parseFloat(agent[1], 10) : NaN;
        vff = agent[2] ? parseFloat(agent[2], 10) : NaN;
        vopera = agent[3] ? parseFloat(agent[3], 10) : NaN;
        vawk = agent[4] ? parseFloat(agent[4], 10) : NaN;
        vair = vsf = vchrome = NaN;
        if (vawk) {
            if (t = airRE.exec(_ua)) {
                vair = 1;
            } else if (t = safariRE.exec(_ua)) {
                if (t.length > 1) {
                    vsf = parseFloat(t[1], 10);
                } else {
                    vsf = 1.0;
                }
            } else if (t = chromeRE.exec(_ua)) {
                if (t.length > 1) {
                    vchrome = parseFloat(t[1], 10);
                } else {
                    vchrome = 1.0;
                }
            }
        }
    } else {
        vie = vff = vopera = vsf = vawk = vair = vchrome = NaN;
        if (typeof ActiveXObject == "function") {
            vie = (/Trident\/4\.0/i.test(navigator.appVersion)) ? 8: 8 - (typeof XDomainRequest == "object" ? 0: 1) - (typeof XMLHttpRequest == "object" ? 0: 1);
        } else if (/AppleWebKit\/\d+\.\d+/i.test(navigator.appVersion)) {
            vawk = parseFloat(navigator.appVersion.replace(/^[\s\S]*?AppleWebKit.(\d+\.\d+)[\s\S]*$/i, "$1"));
            if (typeof openDatabase == "function") {
                vsf = parseFloat(navigator.appVersion.replace(/^[\s\S]*?Version.(\d+\.\d+)[\s\S]*$/i, "$1"));
            }
            if (typeof MessageEvent == "function") {
                vchrome = parseFloat(navigator.appVersion.replace(/^[\s\S]*?chrome.(\d+\.\d+)[\s\S]*$/i, "$1"));
            }
            if (/AdobeAIR/i.test(navigator.appVersion)) {
                vair = 1;
            }
        } else if (typeof document.getBoxObjectFor == "function") {
            vff = parseFloat(navigator.userAgent.replace(/^[\s\S]*?Firefox\/(\d+\.\d+)[\s\S]*$/i, "$1"));
        } else if (typeof opera == "object") {
            vopera = parseFloat(navigator.appVersion.replace(/^(\d+\.\d+)[\s\S]*$/i, "$1"));
        } else {
            vie = 6;
        }
    }
    if (vie) {
        if (vie > 7 && window.navigator && window.navigator.appMinorVersion && window.navigator.appMinorVersion.toLowerCase().indexOf("beta") > -1) {
            isBeta = true;
        }
    }
    if (os) {
        wintype = !!os[1];
        mactype = !!os[2];
        if (wintype) {
            if (t = winRE.exec(_ua)) {
                if (t.length > 0) {
                    winver = parseFloat(t[1], 10);
                }
            }
        }
    } else {
        wintype = mactype = false;
        winver = NaN;
    }
    function adjustBehaviors() {
        if (!adjustBehaviors.adjusted && vie && vie < 7) {
            try {
                document.execCommand('BackgroundImageCache', false, true);
            } catch(ignored) {}
            adjustBehaviors.adjusted = true;
        }
    }
    return {
        beta: isBeta,
        firefox: vff,
        ie: vie,
        opera: vopera,
        air: vair,
        safari: vsf,
        safariV: vsf,
        webkit: vawk,
        windows: winver ? winver: wintype,
        macs: mactype,
        chrome: vchrome,
        adjustBehaviors: adjustBehaviors
    };
})();

QZFL.object = {
    map: function(object, scope, tf) {
        scope = scope || window;
        QZFL.object.each(object, 
        function(value, key) {
            if (typeof(tf) == "string") {
                if (typeof(value == tf)) {
                    scope[key] = value;
                }
            } else {
                scope[key] = value;
            }
        });
    },
    extend: function(object, extendModule) {
        var _t = typeof object;
        if (_t != "object" && _t != "function") {
            return;
        }
        QZFL.object.each(extendModule, 
        function(value, key) {
            object[key] = value;
        });
        extendModule = null;
    },
    each: function(object, fn) {
        if (typeof object != "object" || typeof fn != "function") {
            return false;
        }
        var i = 0,
        k,
        _fn = fn;
        if (Object.prototype.toString.call(object) === "[object Array]") {
            if ( !! object.forEach) {
                object.forEach(fn);
            } else {
                var len = object.length
                while (i < len) {
                    _fn(object[i], i, object); ++i;
                }
            }
        } else {
            for (k in object) {
                _fn(object[k], k, object);
            }
        }
        return true;
    },
    getType: function(object) {
        var _t;
        return ((_t = typeof(object)) == "object" ? object == null && "null" || Object.prototype.toString.call(object).slice(8, -1) : _t).toLowerCase();
    }
};

QZFL.css = {
    getClassRegEx: function(className) {
        var re = QZFL.css.classNameCache[className];
        if (!re) {
            re = new RegExp('(?:^|\\s+)' + className + '(?:\\s+|$)');
            QZFL.css.classNameCache[className] = re;
        }
        return re;
    },
    convertHexColor: function(color) {
        color = /^#/.test(color) ? color.substr(1) : color;
        var reColor = new RegExp("\\w{2}", "ig");
        color = color.match(reColor);
        if (!color || color.length < 3) {
            return [0, 0, 0]
        }
        var r = parseInt(color[0], 16);
        var g = parseInt(color[1], 16);
        var b = parseInt(color[2], 16);
        return [r, g, b];
    },
    styleSheets: {},
    getStyleSheetById: function(id) {
        try {
            return QZFL.dom.get(id).sheet || document.styleSheets[id];
        } catch(e) {
            return null
        }
    },
    getRulesBySheet: function(sheetId) {
        var ss = QZFL.css.getStyleSheetById(sheetId);
        if (ss) {
            try {
                return ss.cssRules || ss.rules;
            } catch(e) {
                return null
            }
        } else {
            return null
        }
    },
    getRuleBySelector: function(sheetId, selector) {
        var _ss = this.getStyleSheetById(sheetId);
        if (!_ss.cacheSelector) {
            _ss.cacheSelector = {}

        };
        if (_ss) {
            var _rs = _ss.cssRules || _ss.rules;
            var re = new RegExp('^' + selector + '$', "i");
            var _cs = _ss.cacheSelector[selector];
            if (_cs && re.test(_rs[_cs].selectorText)) {
                return _rs[_cs];
            } else {
                for (var i = 0; i < _rs.length; i++) {
                    if (re.test(_rs[i].selectorText)) {
                        _ss.cacheSelector[selector] = i;
                        return _rs[i];
                    }
                }
                return null;
            }
        } else {
            return null;
        }
    },
    insertCSSLink: function(url, id) {
        var dom = document,
        cssLink = dom.createElement("link");
        if (id) {
            cssLink.id = id;
        }
        cssLink.rel = "stylesheet";
        cssLink.rev = "stylesheet";
        cssLink.type = "text/css";
        cssLink.media = "screen";
        cssLink.href = url;
        dom.getElementsByTagName("head")[0].appendChild(cssLink);
        return cssLink.sheet || cssLink;
    },
    insertStyleSheet: function(sheetId) {
        var ss = document.createElement("style");
        ss.id = sheetId;
        document.getElementsByTagName("head")[0].appendChild(ss);
        return ss.sheet || ss;
    },
    removeStyleSheet: function(id) {
        var _ss = this.getStyleSheetById(id);
        if (_ss) {
            var own = _ss.owningElement || _ss.ownerNode;
            QZFL.dom.removeElement(own);
        }
    },
    hasClassName: function(elem, cname) {
        return (elem && cname) ? new RegExp('\\b' + cname + '\\b').test(elem.className) : false;
    },
    swapClassName: function(elements, class1, class2) {
        function _swap(el, c1, c2) {
            if (QZFL.css.hasClassName(el, c1)) {
                el.className = el.className.replace(c1, c2);
            } else if (QZFL.css.hasClassName(el, c2)) {
                el.className = el.className.replace(c2, c1);
            }
        }
        if (elements.constructor != Array) {
            elements = [elements];
        }
        for (var i = 0, len = elements.length; i < len; i++) {
            _swap(elements[i], class1, class2);
        }
    },
    replaceClassName: function(elements, sourceClass, targetClass) {
        function _replace(el, c1, c2) {
            if (QZFL.css.hasClassName(el, c1)) {
                el.className = el.className.replace(c1, c2);
            }
        }
        if (elements.constructor != Array) {
            elements = [elements];
        }
        for (var i = 0, len = elements.length; i < len; i++) {
            _replace(elements[i], sourceClass, targetClass);
        }
    },
    addClassName: function(elem, cname) {
        if (elem && cname) {
            if (elem.className) {
                if (QZFL.css.hasClassName(elem, cname)) {
                    return false;
                } else {
                    elem.className += ' ' + cname;
                    return true;
                }
            } else {
                elem.className = cname;
                return true;
            }
        } else {
            return false;
        }
    },
    removeClassName: function(elem, cname) {
        if (elem && cname && elem.className) {
            var old = elem.className;
            elem.className = (elem.className.replace(new RegExp('\\b' + cname + '\\b'), ''));
            return elem.className != old;
        } else {
            return false;
        }
    },
    toggleClassName: function(elem, cname) {
        var r = QZFL.css;
        if (r.hasClassName(elem, cname)) {
            r.removeClassName(elem, cname);
        } else {
            r.addClassName(elem, cname);
        }
    }
}

QZFL.dom = {
    getById: function(id) {
        return document.getElementById(id);
    },
    getByName: function(name, tagName) {
        if (!tagName)
        return document.getElementsByName(name);
        var arr = [];
        var e = document.getElementsByTagName(tagName);
        for (var i = 0; i < e.length; ++i) {
            if ( !! e[i].getAttribute("name") && (e[i].getAttribute("name").toLowerCase() == name.toLowerCase())) {
                arr.push(e[i]);
            }
        }
        return arr;
    },
    get: function(e) {
        if (e && ((e.tagName || e.item) || e.nodeType == 9)) {
            return e;
        }
        return this.getById(e);
    },
    getNode: function(e) {
        if (e && (e.nodeType || e.item)) {
            return e;
        }
        if (typeof e === 'string') {
            return this.getById(e);
        }
        return null;
    },
    removeElement: function(el) {
        if (typeof(el) == "string") {
            el = QZFL.dom.getById(el);
        }
        if (!el) {
            return;
        }
        if (el.removeNode) {
            el.removeNode(true);
        } else {
            if (el.childNodes.length > 0) {
                for (var ii = el.childNodes.length - 1; ii >= 0; ii--) {
                    QZFL.dom.removeElement(el.childNodes[ii]);
                }
            }
            if (el.parentNode) {
                el.parentNode.removeChild(el);
            }
        }
        el = null;
        return null;
    },
    searchElementByClassName: function(el, className) {
        el = this.get(el);
        if (!el) {
            return null
        }
        var re = QZFL.css.getClassRegEx(className);
        while (el) {
            if (re.test(el.className)) {
                return el;
            }
            el = el.parentNode;
        }
        return null;
    },
    getElementsByClassName: function(className, tag, root) {
        tag = tag || '*';
        root = (root) ? this.get(root) : null || document;
        if (!root) {
            return [];
        }
        var nodes = [],
        elements = root.getElementsByTagName(tag),
        re = QZFL.css.getClassRegEx(className);
        for (var i = 0, len = elements.length; i < len; ++i) {
            if (re.test(elements[i].className)) {
                nodes[nodes.length] = elements[i];
            }
        }
        return nodes;
    },
    isAncestor: function(node1, node2) {
        if (!node1 || !node2) {
            return false;
        }
        if (node1.contains && node2.nodeType && !QZFL.userAgent.Safari) {
            return node1.contains(node2) && node1 != node2;
        }
        if (node1.compareDocumentPosition && node2.nodeType) {
            return !! (node1.compareDocumentPosition(node2) & 16);
        } else if (node2.nodeType) {
            return !! this.getAncestorBy(node2, 
            function(el) {
                return el == node1;
            });
        }
        return false;
    },
    getAncestorBy: function(node, method) {
        while (node = node.parentNode) {
            if (node && node.nodeType == 1 && (!method || method(node))) {
                return node;
            }
        }
        return null;
    },
    getFirstChild: function(node) {
        node = this.getNode(node);
        if (!node) {
            return null;
        }
        var child = !!node.firstChild && node.firstChild.nodeType == 1 ? node.firstChild: null;
        return child || this.getNextSibling(node.firstChild);
    },
    getNextSibling: function(node) {
        node = this.getNode(node);
        if (!node) {
            return null;
        }
        while (node) {
            node = node.nextSibling;
            if ( !! node && node.nodeType == 1) {
                return node;
            }
        }
        return null;
    },
    getPreviousSibling: function(node) {
        node = this.getNode(node);
        if (!node) {
            return null;
        }
        while (node) {
            node = node.previousSibling;
            if ( !! node && node.nodeType == 1) {
                return node;
            }
        }
        return null;
    },
    swapNode: function(node1, node2) {
        if (node1.swapNode) {
            node1.swapNode(node2);
        } else {
            var parent = node2.parentNode;
            var next = node2.nextSibling;
            if (next == node1) {
                parent.insertBefore(node1, node2);
            } else if (node2 == node1.nextSibling) {
                parent.insertBefore(node2, node1);
            } else {
                node1.parentNode.replaceChild(node2, node1);
                parent.insertBefore(node1, next);
            }
        }
    },
    createElementIn: function(tagName, el, insertFirst, attributes) {
        tagName = tagName || "div";
        el = this.get(el) || document.body;
        var _doc = el.ownerDocument;
        var _e = _doc.createElement(tagName);
        if (attributes) {
            for (var k in attributes) {
                if (/class/.test(k)) {
                    _e.className = attributes[k];
                } else if (/style/.test(k)) {
                    _e.style.cssText = attributes[k];
                } else {
                    _e[k] = attributes[k];
                }
            }
        }
        if (insertFirst) {
            el.insertBefore(_e, el.firstChild);
        } else {
            el.appendChild(_e);
        }
        return _e;
    },
    getStyle: function(el, property) {
        el = this.get(el);
        if (!el || el.nodeType == 9) {
            return null;
        }
        var w3cMode = document.defaultView && document.defaultView.getComputedStyle;
        var computed = !w3cMode ? null: document.defaultView.getComputedStyle(el, '');
        var value = "";
        switch (property) {
        case "float":
            property = w3cMode ? "cssFloat": "styleFloat";
            break;
        case "opacity":
            if (!w3cMode) {
                var val = 100;
                try {
                    val = el.filters['DXImageTransform.Microsoft.Alpha'].opacity;
                } catch(e) {
                    try {
                        val = el.filters('alpha').opacity;
                    } catch(e) {}
                }
                return val / 100;
            } else {
                return parseFloat((computed || el.style)[property]);
            }
            break;
        case "backgroundPositionX":
            if (w3cMode) {
                property = "backgroundPosition";
                return ((computed || el.style)[property]).split(" ")[0];
            }
            break;
        case "backgroundPositionY":
            if (w3cMode) {
                property = "backgroundPosition";
                return ((computed || el.style)[property]).split(" ")[1];
            }
            break;
        }
        if (w3cMode) {
            return (computed || el.style)[property];
        } else {
            return (el.currentStyle[property] || el.style[property]);
        }
    },
    setStyle: function(el, property, value) {
        el = this.get(el);
        if (!el || el.nodeType == 9) {
            return false;
        }
        var w3cMode = document.defaultView && document.defaultView.getComputedStyle;
        switch (property) {
        case "float":
            property = w3cMode ? "cssFloat": "styleFloat";
            el.style[property] = value;
            return true;
            break;
        case "opacity":
            if (!w3cMode) {
                if (value >= 1) {
                    el.style.filter = "";
                    return;
                }
                el.style.filter = 'alpha(opacity=' + (value * 100) + ')';
                return true;
            } else {
                el.style[property] = value;
                return true;
            }
            break;
        case "backgroundPositionX":
            if (w3cMode) {
                var _y = QZFL.dom.getStyle(el, "backgroundPositionY");
                el.style["backgroundPosition"] = value + " " + (_y || "top");
            } else {
                el.style[property] = value;
            }
            break;
        case "backgroundPositionY":
            if (w3cMode) {
                var _x = QZFL.dom.getStyle(el, "backgroundPositionX");
                el.style["backgroundPosition"] = (_x || "left") + " " + value;
            } else {
                el.style[property] = value;
            }
            break;
        default:
            if (typeof el.style[property] == "undefined") {
                return false
            }
            el.style[property] = value;
            return true;
        }
    },
    createNamedElement: function(type, name, doc) {
        doc = doc || document;
        var element;
        try {
            element = doc.createElement('<' + type + ' name="' + name + '">');
        } catch(ignore) {}
        if (!element || !element.name) {
            element = doc.createElement(type);
            element.name = name;
        }
        return element;
    },
    getPosition: function(el) {
        var xy = QZFL.dom.getXY(el),
        size = QZFL.dom.getSize(el);
        return {
            "top": xy[1],
            "left": xy[0],
            "width": size[0],
            "height": size[1]
        };
    },
    setPosition: function(el, pos) {
        QZFL.dom.setXY(el, pos['left'], pos['top']);
        QZFL.dom.setSize(el, pos['width'], pos['height']);
    },
    getXY: function(el, doc) {
        var _t = 0,
        _l = 0;
        doc = doc || document;
        if (el) {
            if (doc.documentElement.getBoundingClientRect && el.getBoundingClientRect) {
                var box = el.getBoundingClientRect(),
                oDoc = el.ownerDocument,
                _fix = QZFL.userAgent.ie ? 2: 0;
                _t = box.top - _fix + QZFL.dom.getScrollTop(oDoc);
                _l = box.left - _fix + QZFL.dom.getScrollLeft(oDoc);
            } else {
                while (el.offsetParent) {
                    _t += el.offsetTop;
                    _l += el.offsetLeft;
                    el = el.offsetParent;
                }
            }
        }
        return [_l, _t];
    },
    getSize: function(el) {
        var _fix = [0, 0];
        QZFL.object.each(["Left", "Right", "Top", "Bottom"], 
        function(v) {
            _fix[v == "Left" || v == "Right" ? 0: 1] += (parseInt(QZFL.dom.getStyle(el, "border" + v + "Width"), 10) || 0) + (parseInt(QZFL.dom.getStyle(el, "padding" + v), 10) || 0);
        });
        var _w = el.offsetWidth - _fix[0];
        var _h = el.offsetHeight - _fix[1];
        return [_w, _h];
    },
    setXY: function(el, x, y) {
        el = this.get(el);
        var _ml = parseInt(this.getStyle(el, "marginLeft")) || 0;
        var _mt = parseInt(this.getStyle(el, "marginTop")) || 0;
        this.setStyle(el, "left", parseInt(x) - _ml + "px");
        this.setStyle(el, "top", parseInt(y) - _mt + "px");
    },
    getScrollLeft: function(doc) {
        doc = doc || document;
        return Math.max(doc.documentElement.scrollLeft, doc.body.scrollLeft);
    },
    getScrollTop: function(doc) {
        doc = doc || document;
        return Math.max(doc.documentElement.scrollTop, doc.body.scrollTop);
    },
    getScrollHeight: function(doc) {
        doc = doc || document;
        return Math.max(doc.documentElement.scrollHeight, doc.body.scrollHeight);
    },
    getScrollWidth: function(doc) {
        doc = doc || document;
        return Math.max(doc.documentElement.scrollWidth, doc.body.scrollWidth);
    },
    setScrollLeft: function(value, doc) {
        doc = doc || document;
        doc[doc.compatMode == "CSS1Compat" && !QZFL.userAgent.safari ? "documentElement": "body"].scrollLeft = value;
    },
    setScrollTop: function(value, doc) {
        doc = doc || document;
        doc[doc.compatMode == "CSS1Compat" && !QZFL.userAgent.safari ? "documentElement": "body"].scrollTop = value;
    },
    getClientHeight: function(doc) {
        doc = doc || document;
        return doc.compatMode == "CSS1Compat" ? doc.documentElement.clientHeight: doc.body.clientHeight;
    },
    getClientWidth: function(doc) {
        doc = doc || document;
        return doc.compatMode == "CSS1Compat" ? doc.documentElement.clientWidth: doc.body.clientWidth;
    },
    setSize: function(el, width, height) {
        el = this.get(el);
        var _wFix = /\d+([a-z%]+)/i.exec(width);
        _wFix = _wFix ? _wFix[1] : "";
        var _hFix = /\d+([a-z%]+)/i.exec(height);
        _hFix = _hFix ? _hFix[1] : "";
        this.setStyle(el, "width", (typeof width != "number" || width < 0 || /auto/i.test(width)) ? "auto": (parseInt(width) + (_wFix || "px")));
        this.setStyle(el, "height", (typeof height != "number" || height < 0 || /auto/i.test(height)) ? "auto": (parseInt(height) + (_hFix || "px")));
    },
    getDocumentWindow: function(doc) {
        _doc = doc || document;
        return _doc.parentWindow || _doc.defaultView;
    },
    getElementsByTagNameNS: function(node, ns, tgn) {
        var res = [];
        if (node) {
            if (node.getElementsByTagNameNS) {
                return node.getElementsByTagName(ns + ":" + tgn);
            } else if (node.getElementsByTagName) {
                var n = document.namespaces;
                if (n.length > 0) {
                    var l = node.getElementsByTagName(tgn);
                    for (var i = 0, len = l.length; i < len; ++i) {
                        if (l[i].scopeName == ns) {
                            res.push(l[i]);
                        }
                    }
                }
            }
        }
        return res;
    },
    collection2Array: function(coll) {
        if (isArray(coll)) {
            return coll;
        } else {
            var r = [];
            for (var i = 0, len = coll.length; i < len; ++i) {
                r.push(coll[i]);
            }
        }
        return r;
    },
    getElementByTagNameBubble: function(a, tn) {
        if (!isNode(a)) {
            return null;
        }
        tn += "";
        var maxLv = 31;
        while (a && a.tagName && (a.tagName.toLowerCase() != tn.toLowerCase())) {
            if (a == document.body || (--maxLv) < 0) {
                return null;
            }
            a = a.parentNode;
        }
        return a;
    }
};

QZFL.media = {
    _tempImageList: [],
    _flashVersion: null,
    adjustImageSize: function(w, h, trueSrc, callback) {
        var ele = QZFL.event.getTarget();
        if (ua.firefox < 3 && ele === document) {
            ele = QZFL.event.getEvent().currentTarget;
        }
        ele.onload = null;
        var offset,
        _c = QZFL.media._tempImageList;
        _c[offset = _c.length] = new Image();
        _c[offset].onload = (function(mainImg, tempImg, ew, eh) {
            return function() {
                tempImg.onload = null;
                var ow = tempImg.width,
                oh = tempImg.height;
                if (ow / oh > ew / eh) {
                    if (ow > ew) {
                        mainImg.width = ew;
                    }
                } else {
                    if (oh > eh) {
                        mainImg.height = eh;
                    }
                }
                mainImg.src = tempImg.src;
                _c[offset] = null;
                delete _c[offset];
                if (typeof(callback) == 'function') {
                    callback(mainImg, w, h, tempImg, ow, oh);
                }
            };
        })(ele, _c[offset], w, h);
        _c[offset].onerror = function() {
            _c[offset] = null;
            delete _c[offset];
        };
        _c[offset].src = trueSrc;
    },
    getFlashHtml: function(flashArguments, requiredVersion, flashPlayerCID) {
        var _attrs = new QZFL.string.StringBuilder(),
        _params = new QZFL.string.StringBuilder();
        if (typeof(flashPlayerCID) == 'undefined') {
            flashPlayerCID = 'D27CDB6E-AE6D-11cf-96B8-444553540000';
        }
        for (var k in flashArguments) {
            switch (k) {
            case "movie":
                continue;
                break;
            case "id":
            case "name":
            case "width":
            case "height":
            case "style":
                _attrs.append(k + "='" + flashArguments[k] + "' ");
                break;
            default:
                _params.append("<param name='" + ((k == "src") ? "movie": k) + "' value='" + 
                (flashArguments[k])
                + "' />");
                _attrs.append(k + "='" + flashArguments[k] + "' ");
            }
        }
        if (requiredVersion && (requiredVersion instanceof QZFL.media.SWFVersion)) {
            var _ver = QZFL.media.getFlashVersion().major;
            var _needVer = requiredVersion.major;
            _attrs.append("codeBase='http://fpdownload.macromedia.com/get/flashplayer/current/swflash.cab#version=" + requiredVersion + "' ");
        }
        if (ua.ie) {
            return "<object classid='clsid:" + flashPlayerCID + "' " + _attrs + ">" + _params + "</object>";
        } else {
            return "<embed " + _attrs + " pluginspage='http://www.macromedia.com/go/getflashplayer' type='application/x-shockwave-flash'></embed>";
        }
    },
    getWMMHtml: function(wmpArguments, cid) {
        var params = new QZFL.string.StringBuilder();
        var objArgm = new QZFL.string.StringBuilder();
        if (typeof(cid) == 'undefined') {
            cid = "clsid:6BF52A52-394A-11D3-B153-00C04F79FAA6";
        }
        for (var k in wmpArguments) {
            switch (k) {
            case "id":
            case "width":
            case "height":
            case "style":
                objArgm.append(k + '="' + wmpArguments[k] + '" ');
                break;
            case "src":
                objArgm.append(k + '="' + wmpArguments[k] + '" ');
                break;
            default:
                objArgm.append(k + '="' + wmpArguments[k] + '" ');
                params.append('<param name="' + k + '" value="' + wmpArguments[k] + '" />');
            }
        }
        if (wmpArguments["src"]) {

            params.append('<param name="URL" value="' + wmpArguments["src"] + '" />');
        }
        if (ua.ie) {
            return '<object classid="' + cid + '" ' + objArgm + '>' + params + '</object>';
        } else {
            return '<embed ' + objArgm + '></embed>';
        }
    }
}
var insertFlash = QZFL.media.getFlashHtml;
QZFL.shareObject = {};
QZFL.shareObject.instance = {};
QZFL.shareObject.refCount = 0;

if (true) {
    var CYPIC;
    if (typeof(QZFL) == "object") {
        CYPIC = QZFL;
    } else {
        CYPIC = {};
    }
};



//��������һ��JS

(function() {
    jWidget = {
        version: '1.0.0',
        each: function(array, fn) {
            if (typeof array.length == "undefined" || typeof array == "string") {
                array = [array];
            }
            for (var i = 0, len = array.length; i < len; i++) {
                if (fn.call(array[i], array[i], i, array) === false) {
                    return i;
                };
            }
        },
        extend: QZFL.object.extend
    };
    jWidget.dom = QZFL.dom;
    jWidget.extend(QZFL.dom, {
        hasClass: QZFL.css.hasClassName,
        addClass: QZFL.css.addClassName,
        removeClass: QZFL.css.removeClassName
    });
    jWidget.dom.getChildren = function(el) {
        var _arr = [];
        var el = jWidget.dom.getFirstChild(el);
        while (el) {
            if ( !! el && el.nodeType == 1) {
                _arr.push(el);
            }
            el = el.nextSibling;
        }
        return _arr;
    }
    jWidget.Tween = QZFL.Tween;
    jWidget.ui = jWidget.ui || {};
})();; 

(function() {
    var $ = jWidget,
    $D = $.dom;
    _Slide = function(conf) {
        conf = conf || {};
        this.eventType = conf.eventType || 'mouseover',
        this.autoPlayInterval = conf.autoPlayInterval || 3 * 1000;
        this._play = true;
        this._timer = null;
        this._fadeTimer = null;
        this._container = $D.get(conf.container);
        this._panelWrapper = $D.get(conf.panelWrapper) || $D.getFirstChild(this._container);
        this._sliders = $D.getChildren(this._panelWrapper);
        this._navWrapper = $D.get(conf.navWrapper) || $D.getNextSibling(this._panelWrapper) || null;
        this._navs = (this._navWrapper && $D.getChildren(this._navWrapper)) || null;
        this._effect = conf.effect || 'scrollx';
        this._panelSize = (this._effect.indexOf("scrolly") == -1 ? conf.width: conf.height) || $D.getSize($D.getFirstChild(this._panelWrapper))[this._effect.indexOf("scrolly") == -1 ? 0: 1];
        this._count = conf.count || $D.getChildren(this._panelWrapper).length;
        this._navClassOn = conf.navClassOn || "on";
        this._target = 0;
        this._changeProperty = this._effect.indexOf("scrolly") == -1 ? "left": "top";
        this.curIndex = 0;
        this.step = this._effect.indexOf("scroll") == -1 ? 1: (conf.Step || 5);
        this.slideTime = conf.slideTime || 10;
        this.init();
        this.run(true);
    }
    _Slide.prototype = {
        init: function() {
            $D.setStyle(this._container, "overflow", "hidden");
            $D.setStyle(this._container, "position", "relative");
            $D.setStyle(this._panelWrapper, "position", "relative");
            if (this._effect.indexOf("scrolly") == -1) {
                $D.setStyle(this._panelWrapper, "width", this._count * (this._panelSize + 200) + "px");
                $.each(this._sliders, 
                function(el) {
                    el.style.styleFloat = el.style.cssFloat = "left";
                })
            }
            if (this._navs) {
                var _this = this;
                if (_this.eventType == 'click') {
                    $.each(this._navs, 
                    function(el, i) {
                        el.onclick = (function(_this) {
                            return function() {
                                $D.addClass(el, _this._navClassOn);
                                _this._play = false;
                                _this.curIndex = i;
                                _this._play = true;
                                _this.run();
                            }
                        })(_this)
                    })
                } else {
                    $.each(this._navs, 
                    function(el, i) {
                        el.onmouseover = (function(_this) {
                            return function() {
                                $D.addClass(el, _this._navClassOn);
                                _this._play = false;
                                _this.curIndex = i;
                                _this.run();
                            }
                        })(_this)
                        el.onmouseout = (function(_this) {
                            return function() {
                                $D.removeClass(el, _this._navClassOn);
                                _this._play = true;
                                _this.run(false, true);
                            }
                        })(_this)
                    })
                }
            }
        },
        run: function(isInit, noFade) {
            if (this.curIndex < 0) {
                this.curIndex = this._count - 1;
            } else if (this.curIndex >= this._count) {
                this.curIndex = 0;
            }
            this._target = -1 * this._panelSize * this.curIndex;
            var _this = this;
            if (this._navs) {
                $.each(this._navs, 
                function(el, i) {
                    _this.curIndex == (i) ? $D.addClass(el, _this._navClassOn) : $D.removeClass(el, _this._navClassOn);
                })
            }
            this.scroll();
            if (this._effect.indexOf("fade") >= 0 && !noFade) {
                $D.setStyle(this._panelWrapper, "opacity", isInit ? 0.5: 0.1);
                this.fade();
            }
        },
        scroll: function() {
            clearTimeout(this._timer);
            var _this = this,
            _cur_property = parseInt(this._panelWrapper.style[this._changeProperty]) || 0,
            _distance = (this._target - _cur_property) / this.step;
            if (Math.abs(_distance) < 1 && _distance != 0) {
                _distance = _distance > 0 ? 1: -1;
            }
            if (_distance != 0) {
                this._panelWrapper.style[this._changeProperty] = (_cur_property + _distance) + "px";
                this._timer = setTimeout(function() {
                    _this.scroll();
                },
                this.slideTime);
            } else {
                this._panelWrapper.style[this._changeProperty] = this._target + "px";
                if (this._play) {
                    this._timer = setTimeout(function() {
                        _this.curIndex++;
                        _this.run();
                    },
                    this.autoPlayInterval);
                }
            }
        },
        fade: function() {
            var _opacity = $D.getStyle(this._panelWrapper, "opacity");
            var _this = this;
            if (_opacity < 1) {
                $D.setStyle(this._panelWrapper, "opacity", parseFloat(_opacity) + 0.02);
                setTimeout(function() {
                    _this.fade();
                },
                1);
            }
        }
    }
    jWidget.ui.SlideView = function(el, conf) {
        conf = conf || {};
        conf.container = el;
        return new _Slide(conf);
    }
})();; 


jWidget.extend(QZFL.ui = QZFL.ui || {},
jWidget.ui);


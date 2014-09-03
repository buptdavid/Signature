slide3 = function() {
    var c;
    var b = {
        barSlide: "controlBar",
        barArray: "array",
        lists: "slist",
        contentlist: "contentlist"
    };
    var a = {
        leftBar: null,
        rightBar: null,
        barSlide: null,
        lists: null,
        content: null,
        parentContent: null
    };
    var f = {
        height: null,
        listWidth: null,
        parentContentWidth: null
    };
    var e = {
        num: null,
        current: 1
    };
    var h = {
        sTime: 3,
        mTime: 0.5,
        autoRun: false,
        runId: null
    };
    var d = [];
    var g;
    return {
        init: function(i) {
            this.setOptions(i);
            this.preShow();
            this.listenbarSlide();
            this.listenleftBar();
            this.listenrightBar()
        },
        setOptions: function(i) {
            g = this;
            c = i.bar;
            a.parentContent = i.content;
            a.content = D.query("." + b.contentlist, a.parentContent)[0];
            a.lists = D.query("." + b.lists, a.content);
            if (AP.env.browser.msie) {
                f.listWidth = a.content.getAttribute("offsetWidth")
            } else {
                f.listWidth = parseInt(D.getStyle(a.content, "width"))
            }
            e.num = a.lists.length
        },
        preShow: function(i) {
            D.setStyle(a.content, "width", f.listWidth * e.num + "px");
            this.generateDom();
            this.calculatePositionArray()
        },
        generateDom: function(l) {
            Element.create("div", {
                className: b.barArray,
                innerHTML: "<em></em><span></span>",
                appendTo: c
            });
            var k = "<span class='current' name='1'></span>";
            for (var j = 2; j <= e.num; j++) {
                k = k + "<span name='" + j + "'></span>"
            }
            Element.create("div", {
                className: b.barSlide,
                innerHTML: k,
                appendTo: c
            });
            a.leftBar = D.query("." + b.barArray + " em", c)[0];
            a.rightBar = D.query("." + b.barArray + " span", c)[0];
            a.barSlide = D.query("." + b.barSlide + " span", c)
        },
        calculatePositionArray: function(k) {
            d[0] = 0;
            for (var j = 1; j < e.num; j++) {
                d[j] = d[j - 1] - f.listWidth
            }
        },
        listenbarSlide: function(i) {
            a.barSlide.forEach(function(j, k) {
                E.on(j, "click", g.listenbarClick, j, true)
            })
        },
        listenbarClick: function(j, i) {
            E.preventDefault(j);
            e.current = i.getAttribute("name");
            g.moveTo()
        },
        listenleftBar: function(i) {
            E.on(a.leftBar, "mouseover", 
            function() {
                D.addClass(a.leftBar, "hover")
            });
            E.on(a.leftBar, "mouseout", 
            function() {
                D.removeClass(a.leftBar, "hover")
            });
            E.on(a.leftBar, "click", 
            function() {
                e.current--;
                g.moveTo()
            })
        },
        listenrightBar: function(i) {
            E.on(a.rightBar, "mouseover", 
            function() {
                D.addClass(a.rightBar, "hover")
            });
            E.on(a.rightBar, "mouseout", 
            function() {
                D.removeClass(a.rightBar, "hover")
            });
            E.on(a.rightBar, "click", 
            function() {
                e.current++;
                g.moveTo()
            })
        },
        moveTo: function(k) {
            if (e.current > e.num) {
                e.current = 1
            } else {
                if (e.current <= 0) {
                    e.current = e.num
                }
            }
            var j = e.current - 1;
            var i = {
                left: {
                    to: d[j]
                }
            };
            var l = new U.Anim(a.content, i, h.mTime, POSJOYSIM.util.Easing.easeInStrong);
            l.animate();
            l.onComplete.subscribe(function() {
                g.setCurrentBar(j)
            })
        },
        setCurrentBar: function(i) {
            a.barSlide.forEach(function(j, k) {
                D.removeClass(j, "current")
            });
            D.addClass(a.barSlide[i], "current")
        }
    }
};
slide2 = function() {
    var e;
    var c = {
        bar: "bar",
        barSlide: "change",
        barMode: "size",
        bCon: "bCon",
        sCon: "sCon"
    };
    var f = {
        slideBar: null,
        slideBarDom: null,
        size: {
            b: null,
            s: null
        },
        lists: null,
        ul: null,
        bCon: null,
        sCon: null
    };
    var g = {
        width: null,
        inNum: 3,
        ulWidth: null,
        listNum: null,
        listWidth: null,
        firstmarginL: null,
        mode: "S"
    };
    var a = {
        num: null,
        current: 1,
        preNum: null,
        startPosition: null
    };
    var i = [];
    var b = [];
    var h = {
        sTime: 3,
        mTime: 0.5,
        autoRun: false,
        runId: null
    };
    var d;
    return {
        init: function(j) {
            this.setOptions(j);
            this.preShow();
            this.listenslideBar();
            this.listenEvent();
            this.autoRun()
        },
        setOptions: function(j) {
            d = this;
            e = j.id;
            f.lists = D.query("." + c.bCon + " li", e);
            f.ul = D.query("." + c.bCon + " ul", e)[0];
            f.bCon = D.query("." + c.bCon)[0];
            g.listNum = f.lists.length;
            a.num = Math.ceil(g.listNum / g.inNum);
            g.width = e.parentNode.offsetWidth - 2;
            D.setStyle(e, "width", g.width);
            g.listWidth = parseInt(D.getStyle(f.lists[0], "width"));
            g.ulWidth = g.listWidth * g.inNum * a.num;
            D.setStyle(f.ul, "width", g.ulWidth + "px")
        },
        listenEvent: function(j) {
            f.lists.forEach(function(k, l) {
                E.on(k, "mouseover", d.listmouseOver, k, true);
                E.on(k, "mouseout", d.listmouseOut, k, true)
            });
            E.on(f.size.b, "click", this.changeMode, "B", true);
            E.on(f.size.s, "click", this.changeMode, "S", true);
            D.query("li", f.sCon).forEach(function(k, l) {
                E.on(k, "mouseover", d.smallListmouseOver, k, true);
                E.on(k, "mouseout", d.smallListmouseOut, k, true)
            })
        },
        changeMode: function(m, k) {
            if (g.mode != k) {
                if (g.mode == "B") {
                    D.setStyle(f.bCon, "display", "none");
                    D.setStyle(f.bCon, "opacity", 0);
                    D.setStyle(f.sCon, "display", "block");
                    D.addClass(f.slideBarDom, "l-hidden");
                    var j = {
                        opacity: {
                            from: 0,
                            to: 1
                        }
                    };
                    var l = new U.Anim(f.sCon, j, h.mTime / 2, POSJOYSIM.util.Easing.easeInStrong);
                    l.animate()
                } else {
                    D.setStyle(f.sCon, "display", "none");
                    D.setStyle(f.sCon, "opacity", 0);
                    D.setStyle(f.bCon, "display", "block");
                    D.removeClass(f.slideBarDom, "l-hidden");
                    var j = {
                        opacity: {
                            to: 1
                        }
                    };
                    var l = new U.Anim(f.bCon, j, h.mTime / 2, POSJOYSIM.util.Easing.easeInStrong);
                    l.animate()
                }
                g.mode = k
            }
        },
        smallListmouseOver: function(k, j) {
            D.addClass(j, "hover")
        },
        smallListmouseOut: function(k, j) {
            D.removeClass(j, "hover")
        },
        preShow: function(j) {
            this.fixPosition();
            this.generateDom();
            this.calculatePositionArray();
            this.inittBorderList();
            this.show()
        },
        fixPosition: function(j) {
            g.firstmarginL = (g.width - g.listWidth * g.inNum) / 2;
            D.setStyle(f.ul, "left", g.firstmarginL + "px");
            a.startPosition = g.firstmarginL
        },
        generateDom: function(n) {
            var m = Element.create("div", {
                className: c.bar
            });
            D.insertBefore(m, f.ul.parentNode);
            var k = "";
            for (var l = 1; l <= a.num; l++) {
                k += "<span name=" + l + "></span>"
            }
            Element.create("div", {
                className: c.barSlide + " l-hidden",
                innerHTML: k,
                appendTo: m
            });
            var j = Element.create("div", {
                className: c.barMode,
                innerHTML: "<span class='b'></span><span class='s'></span>",
                appendTo: m
            });
            f.sCon = Element.create("div", {
                className: c.sCon,
                innerHTML: "<ul>" + f.ul.innerHTML + "</ul>",
                appendTo: e
            });
            f.size.b = D.query(".b", j)[0];
            f.size.s = D.query(".s", j)[0];
            f.slideBar = D.query("." + c.bar + " ." + c.barSlide + " span", e);
            f.slideBarDom = D.query("." + c.bar + " ." + c.barSlide, e);
            D.addClass(f.slideBar[0], "current")
        },
        recoverList: function(j) {
            setTimeout(function() {
                f.lists.forEach(function(k, l) {
                    D.setStyle(k, "opacity", 1);
                    D.setStyle(k, "cursor", "auto");
                    D.setStyle(D.query(".img img", k)[0], "opacity", 1)
                })
            },
            h.mTime * 100)
        },
        inittBorderList: function(k) {
            var j = b[a.current - 1];
            d.listenLeftrightBar(j);
            d.adjustListOne(j[0]);
            d.adjustListOne(j[1])
        },
        listenLeftrightBar: function(k) {
            b.forEach(function(m, n) {
                E.removeListener(f.lists[m[0]], "click");
                E.removeListener(f.lists[m[1]], "click")
            });
            if (!L.isUndefined(f.lists[k[0]])) {
                var l = f.lists[k[0]];
                E.on(l, "click", 
                function(m, n) {
                    E.preventDefault(m);
                    a.current--;
                    d.moveTo()
                })
            }
            if (!L.isUndefined(f.lists[k[1]])) {
                var j = f.lists[k[1]];
                E.on(j, "click", 
                function(n, m) {
                    E.preventDefault(n);
                    a.current++;
                    d.moveTo()
                })
            }
        },
        adjustListOne: function(m) {
            var k = f.lists[m];
            if (!L.isUndefined(k)) {
                D.setStyle(k, "opacity", 0.3);
                D.setStyle(k, "cursor", "pointer");
                var j = {
                    opacity: {
                        to: 0
                    }
                };
                var l = new U.Anim(D.query(".img img", k)[0], j, h.mTime / 3, POSJOYSIM.util.Easing.easeInStrong);
                l.animate();
                l.onComplete.subscribe(function() {})
            }
        },
        calculatePositionArray: function(l) {
            i[0] = g.firstmarginL;
            b[0] = [ - 1, g.inNum];
            for (var j = 1; j < a.num; j++) {
                var k = b[j - 1];
                b[j] = [k[0] + g.inNum, k[1] + g.inNum];

                i[j] = i[j - 1] - g.inNum * g.listWidth
            }
        },
        show: function(j) {
            D.setStyle(f.ul, "visibility", "visible")
        },
        listmouseOver: function(k, j) {
            D.addClass(j, "hover");
            d.parseRun()
        },
        listmouseOut: function(k, j) {
            D.removeClass(j, "hover");
            d.autoRun()
        },
        listenslideBar: function(j) {
            f.slideBar.forEach(function(k, l) {
                E.on(k, "click", d.listenbarClick, k, true)
            })
        },
        listenbarClick: function(k, j) {
            a.current = j.getAttribute("name");
            d.moveTo();
            d.parseRun();
            d.autoRun()
        },
        moveTo: function(m) {
            this.recoverList();
            var l = b[a.current - 1];
            setTimeout(function() {
                if (l[0]) {
                    d.adjustListOne(l[0])
                }
                if (l[1]) {
                    d.adjustListOne(l[1])
                }
            },
            500);
            var k = a.current - 1;
            var j = {
                left: {
                    to: i[k]
                }
            };
            var n = new U.Anim(f.ul, j, h.mTime, POSJOYSIM.util.Easing.easeInStrong);
            n.animate();
            n.onComplete.subscribe(function() {
                d.setCurrentBar(k);
                var o = b[a.current - 1];
                d.listenLeftrightBar(o)
            })
        },
        setCurrentBar: function(j) {
            f.slideBar.forEach(function(k, l) {
                D.removeClass(k, "current")
            });
            D.addClass(f.slideBar[j], "current")
        },
        autoRun: function(j) {
            if (h.autoRun) {
                var k = function() {
                    a.current++;
                    if (a.current > a.num) {
                        a.current = 1
                    } else {
                        if (a.current <= 0) {
                            a.current = 1
                        }
                    }
                    d.moveTo()
                };
                h.runId = setInterval(k, h.sTime * 1000)
            }
        },
        parseRun: function(j) {
            clearInterval(h.runId)
        }
    }
};
slide = function() {
    var e = "content";
    var f = "list";
    var A;
    var p = "control";
    var w;
    var r;
    var q;
    var i = "masklayerTop";
    var a = "masklayerBottom";
    var s = "masklayerMiddle";
    var h = "slideTitle";
    var j;
    var o = {
        top: {},
        middle: {},
        bottom: {}
    };
    var d = true;
    var l = 1;
    var k = false;
    var g = 10;
    var v;
    var y;
    var u;
    var z = function() {
        var B = function() {
            if (!k) {
                if (l >= w.length) {
                    l = 0
                }
                x(l++)
            }
        };
        v = setInterval(B, g * 1000)
    };
    var x = function(B) {
        if (D.getStyle(A[B], "visibility") != "visible") {
            D.setStyle(A[B], "visibility", "visible")
        }
        A.forEach(function(C, F) {
            D.setStyles(C, {
                opacity: 0,
                "z-index": 0
            })
        });
        if (D.query("h4", A[B])[0]) {
            j.innerHTML = D.query("h4", A[B])[0].innerHTML
        }
        fade = new U.Anim(A[B], {
            opacity: {
                to: 1
            },
            width: {
                from: 1000,
                to: 960
            }
        },
        0.3);
        fade.animate();
        fade.onComplete.subscribe(function() {
            D.setStyle(A[B], "z-index", 1)
        });
        w.forEach(function(C, F) {
            if (F == B) {
                D.addClass(C, "current")
            } else {
                D.removeClass(C, "current")
            }
        })
    };
    var b = function(F) {
        var C = Element.create("ul", {
            className: p,
            appendTo: r
        });
        for (var B = 0; B < A.length; B++) {
            Element.create("li", {
                innerHTML: "<span>" + (B + 1) + "</span>",
                appendTo: C
            })
        }
        D.addClass(D.query("." + p + " li:first-child", r)[0], "current");
        w = D.query("." + p + " li", r)
    };
    var m = function(B) {
        o.top = Element.create("div", {
            className: i,
            appendTo: r
        });
        Element.create("div", {
            className: "i",
            appendTo: o.top
        })
    };
    var t = function(B) {
        o.middle = Element.create("div", {
            className: s,
            appendTo: r
        })
    };
    var c = function(B) {
        o.bottom = Element.create("div", {
            className: a,
            appendTo: r
        });
        Element.create("div", {
            className: "i",
            appendTo: o.bottom
        })
    };
    var n = function(B) {
        j = Element.create("h4", {
            className: h,
            appendTo: r
        })
    };
    return {
        init: function(B) {
            this.setOptions(B);
            this.createDom();
            this.preLoad();
            z();
            this.listen()
        },
        setOptions: function(B) {
            r = B.box;
            if (!L.isUndefined(B.delayTime)) {
                g = B.delayTime
            }
            u = this;
            A = D.query("." + e + " a." + f, r);
            if (!L.isUndefined(B.showMaster)) {
                d = B.showMaster
            }
        },
        createDom: function(B) {
            t();
            if (d) {
                m();
                c()
            }
            b();
            n()
        },
        listen: function(B) {
            w.forEach(function(C, F) {
                E.on(C, "mousedown", 
                function(G) {
                    k = true;
                    l = F;
                    x(F);
                    clearInterval(v)
                });
                E.on(C, "mouseup", 
                function(G) {
                    k = false;
                    l++;
                    z();
                    clearInterval(y)
                })
            })
        },
        preLoad: function(C) {
            var B = D.query("." + e + " a:first-child", r)[0];
            j.innerHTML = D.query("h4", B)[0].innerHTML;
            D.setStyle(B, "visibility", "visible")
        }
    }
} ();
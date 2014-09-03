var smsCodeTime = 1; //短信随机码有效时间
var reloadFreshCount = 0; //执行过看不清
var needRefreshRandCode = true; //当前是否需要重刷
var minReFetchTime = 30;
function setSmsCodeTime(expiresTime, resendTime) {
    smsCodeTime = expiresTime;
    minReFetchTime = resendTime;
}

String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
var $ = function(id) {
    return document.getElementById(id);
}

/*0.原ajaxJs.js------------------------------------------------------------------------------------------------------------*/
// JavaScript Document
Function.EMPTY = function() {};
var Ajax = {
    xmlhttp: [],
    //Saves xmlhttp requests
    reuse: [],
    //Indicates whether a xmlhttp can be reallocated.
    timer: [],
    //Timer for each xmlhttp
    option: [],
    //maxnum  : 99, //Maximum number of requests 
    getXmlHttp: function() {
        var xmlhttp = null;
        if (window.ActiveXObject) {
            var version = ['Microsoft.XMLHTTP', 'MSXML.XMLHTTP', 'Msxml2.XMLHTTP.7.0', 'Msxml2.XMLHTTP.6.0', 'Msxml2.XMLHTTP.5.0', 'Msxml2.XMLHTTP.4.0', 'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP'];
            for (var i = 0; i < version.length; i += 1) {
                try {
                    xmlhttp = new window.ActiveXObject(version[i]);
                    if (xmlhttp !== null) {
                        break;
                    }
                } catch(e) {
                    //window.alert(e.description);
                    xmlhttp = null;
                }
            }
            //add by @author:peter
            if (xmlhttp == null) {
                for (var i = 0; i < version.length; i += 1) {
                    try {
                        xmlhttp = new ActiveXObject(version[i]);
                        if (xmlhttp !== null) {
                            break;
                        }
                    } catch(e) {
                        //window.alert(e.description);
                        xmlhttp = null;
                    }
                }
            }
            if (xmlhttp == null) {
                alert("对不起，操作系统或浏览器对ajax支持不佳！");
            }
        } else {
            xmlhttp = new XMLHttpRequest();
            if (xmlhttp && xmlhttp.overrideMimeType) {
                xmlhttp.overrideMimeType('text/xml');
            }
        }
        if (!xmlhttp) {
            window.alert("Failed to create a xmlhttp object!");
        }
        return xmlhttp;
    },
    onState: function(index) {},
    onReady: function(index) {},
    onTimer: function(index) {},
    //onError : function (index) {},
    //onEvent : function (index, evtName) {}, 
    assign: function(reuse) {
        var length = this.xmlhttp.length;
        for (var i = 0; i < length; i += 1) {
            if (!this.reuse[i]) {
                continue;
            }
            var state = this.xmlhttp[i].readyState;
            if (this.xmlhttp[i] === null || state === 0 || state === 4) {
                this.xmlhttp[i] = null;
                var xmlhttp = this.getXmlHttp(true);
                if (xmlhttp) {
                    this.xmlhttp[i] = xmlhttp;
                    this.reuse[i] = reuse;
                    return i;
                }
            }
        }
        //if (length > this.maxnum)
        //{
        //window.alert("No more request is available!");
        //return -1;
        //} 
        var xmlHttp = this.getXmlHttp(true);
        if (xmlHttp) {
            this.xmlhttp.push(xmlHttp);
            this.reuse.push(reuse);
            return length;
        }
        return - 1;
    },
    get: function(index) {
        return this.verify(index) ? this.xmlhttp[index] : null;
    },
    set: function(index) {},
    put: function(index) {
        if (!this.verify(index)) {
            return;
        }
        this.xmlhttp[index].abort();
        this.reuse[index] = true;
        if (this.timer[index]) {
            window.clearTimeout(this.timer[index]);
        }
    },
    verify: function(index) {
        return Math.floor(index) == index && index >= 0 && index < this.xmlhttp.length;
    },
    clear: function(index) {
        if (!this.verify(index)) {
            return;
        }
        if (!this.timer[index]) {
            return;
        }
        window.clearTimeout(this.timer[index]);
        this.timer[index] = null;
    },
    ready: function(index) {
        if (!this.verify(index)) {
            return false;
        }
        return this.xmlhttp[index].readyState == 4 && this.xmlhttp[index].status == 200;
    },
    abort: function(index) {
        this.clear(index);
        if (this.verify(index)) {
            this.xmlhttp[index].onreadystatechange = Function.EMPTY;
            this.xmlhttp[index].abort();
        }
    },
    state: function(index) {
        return this.verify(index) ? this.xmlhttp[index].readyState: -1;
    },
    status: function(index) {
        return this.verify(index) ? this.xmlhttp[index].status: -1;
    },
    header: function(index, name, value) {
        if (!this.verify(index)) {
            return null;
        }
        if (typeof value == 'undefined') {
            return this.xmlhttp[index].getRequestHeader(name);
        }
        return this.xmlhttp[index].setRequestHeader(name, value);
    },
    response: function(index, xml) {
        if (!this.verify(index)) {
            return false;
        }
        return xml ? this.xmlhttp[index].responseXML: this.xmlhttp[index].responseText;
    },
    open: function(index, method, url, aysn, callback, type) {
        if (typeof aysn == 'undefined') {
            aysn = true;
        }
        if (typeof callback == 'undefined') {
            callback = null;
        }
        if (typeof type == 'undefined') {
            type = 'ALL';
        }
        if (!this.verify(index)) {
            return;
        }
        this.clear(index);
        var pthis = this;
        this.xmlhttp[index].onreadystatechange = function() {
            if (pthis.ready(index)) {
                pthis.clear(index);
                pthis.onReady(index);
                if (callback && type == 'READY') {
                    callback(index);
                }
            }
            if (pthis.state(index) == 4 && callback && type == 'COMPLETE') {
                pthis.clear(index);
                callback(index);
            }
            if (callback && type == 'ALL') {
                callback(index);
            }
            pthis.onState(index);
        };
        //url = url +(url.indexOf('?') > -1 ?  "&" : "?") + "ajax="; 
        this.option[index] = new Array(method, url, aysn);
        this.xmlhttp[index].open(method, url, aysn);
        this.xmlhttp[index].setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
    },
    reopen: function(index) {
        if (!this.verify(index)) {
            return;
        }
        this.open(index, this.option[index][0], this.option[index][1], this.option[index][2]);
    },
    send: function(index, data, timeout, callback) {
        if (!this.verify(index)) {
            return;
        }
        this.clear(index);
        if (typeof timeout != 'undefined') {
            var pthis = this;
            this.timer[index] = window.setTimeout(function() {
                pthis.onTimer(index);
                if (callback) {
                    callback(index);
                }
            },
            timeout);
        }
        this.xmlhttp[index].send(data);
    }
};
//请求url,返回的界面，刷新界面中id块的显示内容
function ajaxFresh(url, id) {
    //url=checkUrl(url,['rtype']);
    var ajaxAction = Ajax.assign();
    if (!Ajax.verify(ajaxAction)) {
        alert("Ajax...");
        return;
    }
    Ajax.open(ajaxAction, "POST", url, true,
    function(ajax) {
        //if($(id)){}
        $(id).innerHTML = Ajax.response(ajax);
    },
    "READY");
    Ajax.send(ajaxAction, "");
}
//zhAttrNames为url中包含中文参数名，为数组格式数据
function ajaxFreshZh(url, id, zhAttrNames) {
    url = checkUrl(url, zhAttrNames);
    ajaxFresh(url, id);
}
//对url中包含中文参数值，进行urf8编码
function checkUrl(url, zhAttrNames) {
    var array = url.split("&");
    for (var i = 0; i < array.length; i += 1) {
        var temp = array[i].split("=");
        for (var j = 0; j < zhAttrNames.length; j += 1) {
            if (temp[0] == zhAttrNames[j]) {
                url = url.replace("&" + zhAttrNames[j] + "=" + temp[1], "&" + zhAttrNames[j] + "=" + encodeURIComponent(temp[1]));
            }
        }
    }
    return url;
}
/*1.原huamen.js，用于首页中排行榜之间切换时点击js-------------------------------------------------------------------------------*/
function HoverLi(n) {
    for (var i = 1; i <= 4; i++) {
        $('tb_' + i).className = 'normaltab';
        $('tbc_0' + i).className = 'undis';
    }
    $('tbc_0' + n).className = 'dis';
    $('tb_' + n).className = 'hovertab';
}
/*2.原signinfo.js，---------------------------------------------------------------------------------------------------------*/
var SignInfo = {};
function toLoginDiv(code) {
    if (code == 'ALERT_NOT_LOGIN') {
        login.show();
    } else {
        if (code.length > 50) {
            //系统忙
            alert(i18n['ALERT_SYSTEM_BUSY']);
            return;
        }
        alert(i18n[code]);
    }
}
/* 添加原创签名*/
SignInfo.add = function() {
	var actionCheckCode=$('actionCheckCode');
	if(actionCheckCode&&actionCheckCode.value.trim().length!=4){
		alert("请输入四位校验码！");
		return ;
	}
    var id = $("signGroupId").value;
    var content = $("signContext").value;
    var openSign = $("openSign");
    if (/^\s*$/.test(content)) {
        alert('您还未输入彩印内容！');
    } else if (window.confirm('您是否确认提交？')) {
        var url = "ncreate.html?info.siGroupid=" + id + "&info.siCard=" + encodeURIComponent(content) + "&openSign=" + openSign.checked + "&random=" + Math.random();
        if(actionCheckCode){
        	url=url+"&actionCheckCode="+actionCheckCode.value;
        }
        location.href = url;
    }
};
var Vote = {};
/* 投票 */
Vote.vote = function(id) {
    var url = "vote.html?id=" + id + "&random=" + Math.random();
    //设置用户操作动作
    setCookie("cspClickAction", "vote.html");
    setCookie("cspClickAction_id", id);

    var ajaxVote = Ajax.assign();
    if (!Ajax.verify(ajaxVote)) return false;
    Ajax.open(ajaxVote, "post", url, true,
    function(ajax) {
        toLoginDiv(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxVote, "");
    return true;
};
function StripHtml(html) {
    html = html || "";
    var scriptregex = "<scr" + "ipt[^>.]*>[sS]*?</sc" + "ript>";
    var scripts = new RegExp(scriptregex, "gim");
    html = html.replace(scripts, " ");
    //Stripts the <style> tags from the html
    var styleregex = "<style[^>.]*>[sS]*?</style>";
    var styles = new RegExp(styleregex, "gim");
    html = html.replace(styles, " ");
    //Strips the HTML tags from the html
    var objRegExp = new RegExp("<(.| )+?>", "gim");
    var strOutput = html.replace(objRegExp, " ");
    //Replace all < and > with &lt; and &gt;
    strOutput = strOutput.replace(/</, "&lt;");
    strOutput = strOutput.replace(/>/, "&gt;");
    objRegExp = null;
    return strOutput;
}
Vote.count = function(id) {
    /*
    var url = "voteCount.html?id=" + id + "&random=" + Math.random();
    var ajaxVote = Ajax.assign();
    if (!Ajax.verify(ajaxVote)) return false;
    Ajax.open(ajaxVote, "post", url, true, function (ajax) 
    {
        var responseCode = Ajax.response(ajax);
        if(responseCode != "00") {
           $(id+"_span").innerHTML = responseCode;
        }
    }, "READY");
    Ajax.send(ajaxVote, ""); return true;*/
}
var Collection = {};
/* 添加收藏 */
Collection.add = function(id) {
    var url = "collect.html?id=" + id + "&random=" + Math.random();
    //设置用户操作动作
    setCookie("cspClickAction", "collect.html");
    setCookie("cspClickAction_id", id);
    //
    var ajaxAdd = Ajax.assign();
    if (!Ajax.verify(ajaxAdd)) return false;
    Ajax.open(ajaxAdd, "post", url, true,
    function(ajax) {
        toLoginDiv(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxAdd, "");
    return true;
};
Collection.count = function(id) {
    /*
    var url = "collectCount.html?id=" + id + "&random=" + Math.random();
    var ajaxRemove = Ajax.assign();
    if (!Ajax.verify(ajaxRemove)) return false;
    Ajax.open(ajaxRemove, "post", url, true, function (ajax) {
        var responseCode = Ajax.response(ajax);
        if(responseCode != "00") {
           $(id+"_span_collect").innerHTML = responseCode;
        }
    }, "READY");
    Ajax.send(ajaxRemove, ""); return true;*/
};
/* 取消收藏 */
Collection.remove = function(id) {
    var url = "drop.html?id=" + id + "&random=" + Math.random();
    var ajaxRemove = Ajax.assign();
    if (!Ajax.verify(ajaxRemove)) return false;
    Ajax.open(ajaxRemove, "post", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxRemove, "");
    return true;
};

var CustomRule={};
/*专属彩印设置*/
CustomRule.set=function(id,content,packageId){
     if (id == ''&&content==''&&packageId=='') {
        alert('请选择彩印/彩印盒！');
        return false;
    }
    //设置用户操作动作
    setCookie("cspClickAction", "toCustomSignRule.html");
    setCookie("cspClickAction_rule.content", encodeURIComponent(content));
    setCookie("cspClickAction_rule.id", id);
    setCookie("cspClickAction_signPackageId",packageId);
    //
    var url = "checkSession.html?random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        customRuleRsponse(Ajax.response(ajax), id, content,packageId, false);
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var customRuleRsponse = function(responseCode, id, content,packageId, isEncode) {
    if (responseCode == "-1") {
            login.show();
    } else {
            var url = "toCustomSignRule.html?random=" + Math.random();
            if(isNotBlank(id)){
            	url=url+"&rule.id=" + id ;
            }
            if(isNotBlank(content)){
	            if (!isEncode) {
	                content = encodeURIComponent(content);
	            }
	            url=url+"&rule.content=" + content;
            }
            if(isNotBlank(packageId)){
                url=url+"&rule.signPackageId=" + packageId; 
            }
            sAlert(url, 480, 275, '专属彩印设置', 30, 150);
            return true;
    }
}

function isNotBlank(Str){
	if(Str!=null&&Str.trim().length>0){
		return true;
	}
	return false;
}


var CommonSet = {};
/* 设置默认签名 */
CommonSet.set = function(id, content) {
	//alert("id:"+id+" #content:"+content);
    if (content == '') {
        alert('签名内容不能为空');
        return false;
    }
    //设置用户操作动作
    setCookie("cspClickAction", "commonSetByIndex.html");
    setCookie("cspClickAction_rule.content", encodeURIComponent(content));
    setCookie("cspClickAction_rule.id", id);

    var url = "checkSession.html?random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        commonsetRsponse(Ajax.response(ajax), id, content, false);
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var commonsetRsponse = function(responseCode, id, content, isEncode) {
    if (responseCode == "-1") {
    	if("gd10086Iframe"==getCookie("pageType")){
    		setCookie("pageType","");
    		alert("对不起，您尚未登录！");
    	}else{
            login.show();
    	}
    } else {
    	setCookie("pageType","");
        if (confirm(i18n['ALERT_COMMON_SIGN_CONFIRM'])) {
            if (!isEncode) {
                content = encodeURIComponent(content);
            }
            var url = "commonSetByIndex.html?rule.content=" + content + "&rule.id=" + id + "&random=" + Math.random();
            var ajaxSet = Ajax.assign();
            if (!Ajax.verify(ajaxSet)) return false;
            Ajax.open(ajaxSet, "POST", url, true,
            function(ajax) {
                handleResponseCode(Ajax.response(ajax));
            },
            "READY");
            Ajax.send(ajaxSet, "");
            return true;
        }
    }
}
CommonSet.cancelTmp = function() {
    if (confirm("您确认要取消临时彩印设置？")) {
        var url = "commonSetByIndex.html?cancelTmpSign=true";
        var ajaxSet = Ajax.assign();
        if (!Ajax.verify(ajaxSet)) return;
        Ajax.open(ajaxSet, "POST", url, true,
        function(ajax) {
            handleResponseCode(Ajax.response(ajax));
        },
        "READY");
        Ajax.send(ajaxSet, "");;
    }
}

/*139设置彩印*/
var SignSetBy139 = {};

SignSetBy139.set = function(syncStatus, content, nickName) {
    content = encodeURIComponent(content);
    var url = "setBy139.html?sign139=" + content + "&syncStatus=" + syncStatus + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        setBy139Rsponse(Ajax.response(ajax), nickName, syncStatus);
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var setBy139Rsponse = function(responseCode, nickName, syncStatus) {
    if (responseCode == "0") {
        //1表示同步，0表示不同步
        if (syncStatus == 1) {
            alert('设置成功，您已经成功设置自动同步说客内容为彩印!');
        } else {
            alert('您的设置已经提交！');
        }
        return;
    } else if (responseCode == "-003") {
        alert(i18n['ALERT_SYSTEM_BUSY']);
        return;
    } else if (responseCode == "-1") {
        alert('会话已超时，请重新登录！');
        document.location.href = 'loginFrom139.html';
    } else if (responseCode == "1") {
        if (confirm('昵称不一致，是否使用139昵称作为彩印昵称？')) {
            nickName = encodeURIComponent(nickName);
            var url = "updateNickName.html?user.suNick=" + nickName + "&random=" + Math.random();
            var ajaxSet = Ajax.assign();
            if (!Ajax.verify(ajaxSet)) return false;
            Ajax.open(ajaxSet, "POST", url, true,
            function(ajax) {
            	//昵称同步可能失败，返回昵称允许最大长度
            	var msg=Ajax.response(ajax);
                    if(msg>0&&msg<50){
                        alert("对不起！同步昵称失败，彩印昵称最大允许为"+msg+"个字符！");
                        return ;
                    }
                handleResponseCode(msg);
            },
            "READY");
            Ajax.send(ajaxSet, "");
            return true;
        } else {
            //1表示同步，0表示不同步
            if (syncStatus == 1) {
                alert('设置成功，您已经成功设置自动同步说客内容为彩印!');
            } else {
                alert('您的设置已经提交！');
            }
            return;
        }
    } else {
        alert(i18n[responseCode]);
        return;
    }
}

var SignPackage = {};
SignPackage.collect = function(id) {
    var url = "collectPackage.html?signPackageId=" + id + "&random=" + Math.random();
    //设置用户操作动作
    setCookie("cspClickAction", "collectPackage.html");
    setCookie("cspClickAction_signPackageId", id);
    //
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    //Ajax.open(ajaxSet, "POST", url, true, function (ajax) {handleResponseCode(Ajax.response(ajax));}, "READY");
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        toLoginDiv(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
/* 设置彩印盒 */
SignPackage.set = function(id) {
    var url = "checkSession.html?random=" + Math.random();

    //设置用户操作动作
    setCookie("cspClickAction", "setSignPackageByIndex.html");
    setCookie("cspClickAction_signPackage.id", id);

    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        commonsetRsponse2(Ajax.response(ajax), id);
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var commonsetRsponse2 = function(responseCode, id) {
    if (responseCode == "-1") {
        login.show();
    } else {

        var url = "setSignPackageByIndex.html?signPackage.id=" + id + "&random=" + Math.random();
        var ajaxSet = Ajax.assign();
        if (!Ajax.verify(ajaxSet)) return false;
        Ajax.open(ajaxSet, "POST", url, true,
        function(ajax) {
            handleResponseCode(Ajax.response(ajax));
        },
        "READY");
        Ajax.send(ajaxSet, "");
        return true;
    }
}
SignPackage.cancelTemp = function() {
    if (confirm('您确定要取消此临时彩印盒设置？')) {
        var url = "setSignPackageByIndex.html?cancelTmpSign=true";
        var ajaxSet = Ajax.assign();
        if (!Ajax.verify(ajaxSet)) return;
        Ajax.open(ajaxSet, "POST", url, true,
        function(ajax) {
            handleResponseCode(Ajax.response(ajax));
        },
        "READY");
        Ajax.send(ajaxSet, "");
        return;
    }
}

var GroupApply = {};
/* 集团提交彩印申请*/
GroupApply.apply = function(content, signNo) {
    return GroupApply.apply1(content, false, signNo);
};
GroupApply.apply0 = function(content, justASignal) {
    return GroupApply.apply1(content, justASignal, 1);
};
/* 集团提交彩印申请*/
GroupApply.apply1 = function(content, justASignal, signNo) {
    if (content == '') {
        alert('彩印内容不能为空');
        return false;
    }
    var url = "existWaitApply.html?signNo=" + signNo + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        groupApplyResponse(Ajax.response(ajax), content, justASignal);
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var groupApplyResponse = function(responseCode, content, justASignal) {
    content = encodeURIComponent(content);
    if (responseCode == "-1") {
        if (confirm('您当前已存在待审核的彩印修改，是否覆盖？')) {
            document.location.href = 'gpApply.html?card=' + content + '&justASignal=' + justASignal;
        } else {
            return false;
        }
    } else {
        document.location.href = 'gpApply.html?card=' + content + '&justASignal=' + justASignal;
    }
}
var UserExist = {};
/* 昵称是否存在 */
UserExist.existName = function(nickName) {
    nickName = encodeURIComponent(nickName);
    var url = "existNickName.html?user.suNick=" + nickName + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "POST", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var UserLogin = {};
/* 用户登录 */
UserLogin.login = function(userId, password, checkcode, model) {
    checkcode = encodeURIComponent(checkcode);
    var url = "ajaxLogin.html?userId=" + userId + "&password=" + password + "&checkcode=" + checkcode + "&model=" + model + "&random=" + Math.random();
    if (model == 0) { //密码强度校验
        url = url + "&passlevel=" + getPassLevel(password);
    }
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "post", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var RandCode = {};
/* 发送短信随机码 */
RandCode.sent = function(userId, randCodeType) {
    userId = encodeURIComponent(userId);
    var url = "sendRandCode.html?user.id=" + userId + "&randCodeType=" + randCodeType + "&needCheckPhone=true" + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "GET", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var GpRandCode = {};
GpRandCode.sent = function(userId, randCodeType, needCheckPhone) {
    userId = encodeURIComponent(userId);
    var url = "sendRandCode.html?user.id=" + userId + "&randCodeType=" + randCodeType + "&needCheckPhone=" + needCheckPhone + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "GET", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var SyncUser = {};
SyncUser.syncTalk = function(userId, stauts) {
    var url = "syncTalk.html?user.id=" + userId + "&user.syncStatus=" + stauts + "&random=" + Math.random();
    var ajaxSet = Ajax.assign();
    if (!Ajax.verify(ajaxSet)) return false;
    Ajax.open(ajaxSet, "post", url, true,
    function(ajax) {
        handleResponseCode(Ajax.response(ajax));
    },
    "READY");
    Ajax.send(ajaxSet, "");
    return true;
};
var handleResponseCode = function(responseCode) {
    if (responseCode.indexOf('尝试登录网站') != -1 || (responseCode.indexOf('太过频繁') != -1 && responseCode.indexOf('<div') < 0)) {
        alert(responseCode);
        return;
    }

    var indexStr = "<span id=\"errorTips\">";
    var index = responseCode.indexOf(indexStr);
    if (index > 0) {
        var index2 = responseCode.indexOf("</span><span id=\"errorTip2\"></span>");
        alert(responseCode.substring(index + indexStr.length, index2));
        return;
    }

    if (responseCode != '' && responseCode.indexOf("04") != 0 && responseCode.length > 20) {
        //系统忙
        alert(i18n['ALERT_SYSTEM_BUSY']);
        return;
    }
    if (responseCode == "261") {
        alert("取消临时彩印/彩印盒操作已经提交！");
        window.location = 'preGeneralSet.html';
        return;
    }
    if (responseCode == "0") {
        alert('您的设置已经提交！');
        return;
    }
    //请您先登录！
    if (responseCode == "-1") {
        //alert(i18n['ALERT_NOT_LOGIN']);
        login.show();
        return;
    }
    //您输入的验证码不正确，请重新输入！
    if (responseCode == "-10") {
        alert(i18n['ALERT_RANDCODE_ERROR']);
        return;
    }
    if (responseCode == "1045000020016") {
        //手机号或密码不正确
        alert(i18n['ALERT_USER_PWD_ERROR']);
        return;
    }
    if (responseCode == "00") {
        //alert(i18n['sign.vote.login.before']);
        login.show();
        return;
    }
    if (responseCode == "01") {
        alert(i18n['sign.vote.success']);
        return;
    }
    if (responseCode == "02") {
        alert(i18n['sign.collect.success']);
        return;
    }
    if (responseCode == "03") {
        alert(i18n['sign.cancel.collect.success']);
        return;
    }
    if (responseCode == "04") {
        alert(i18n['submit.sign.success']);
        return;
    }
    //短信随机码已成功发送，请您注意查收！
    if (responseCode == "005") {
        alert(i18n['ALERT_SMSCODE_SUCCESS'] + " \r\n\r\n短信随机码有效时间为：" + smsCodeTime + "分钟。");
        return;
    }
    //短信随机码已经发送，请您稍后再试！
    if (responseCode == "-001") {
        alert(i18n['ALERT_SMSCODE_BUSY'] + " 请" + minReFetchTime + "秒后重新点击获取。");
        return;
    }
    //没开通业务
    if (responseCode == "-002") {
        alert(i18n['ALERT_SMSCODE_SUCCESS'] + '\r\n\r\n' + i18n['ALERT_SERVICE_NOT_OPEN']);
        return;
    }
    //发送失败
    if (responseCode == "-003") {
        alert(i18n['ALERT_SYSTEM_BUSY']);
        return;
    }
    //号码格式不对
    if (responseCode == "-004") {
        alert(i18n['ALERT_PHONE_INVALID']);
        return;
    }
    if (responseCode == "800") {
        alert('您当前使用的已经是该彩印盒！');
        return;
    }
    if (responseCode == "801") {
        alert('您的设置已经提交！');
        return;
    }
    if (responseCode == "1050000000018") {
        alert('用户昵称字符太长，同步失败！');
        return;
    }
    /*
     if(responseCode == "820") {
        alert('您已经收藏了该彩印盒！');
        return;
    }
     if(responseCode == "821") {
        alert('收藏彩印盒成功！');
        return;
    }*/
    if (responseCode == "830") {
        alert('您的设置已经提交！');
        document.location.href = 'setSignBy139.html';
        return;

    }
    if (responseCode.indexOf("04") == 0) {
        var index = responseCode.indexOf("&");
        if (index == -1) {
            alert(responseCode.substring(2));
        } else {
            if (confirm(responseCode.substring(2, index))) {
                Collection.add(responseCode.substring(index + 1));
            }
        }
        return;
    }
    if (responseCode == "10") {
        //设置成功
        alert(i18n['ALERT_COMMON_SIGN_SUCCESS']);
        return;
    }
    if (responseCode == "110") {
        alert('当前使用的已经是该彩印');
        return;
    }
    if (responseCode == "20") {
        alert('当前昵称已经被使用');
        return;
    }
    if (responseCode == "000") {
        //ajaxFresh('loginPortlet.html','loginBlock');
        //login.hide();var qm=getUrlParamValue("qm");
        var qm = getUrlParamValue("qm");
        if (qm != null && qm.length > 0) {
            window.top.location.href = "index.html?signInfo.siCard=" + encodeURIComponent(qm);
        } else {

            //如果通过弹出框登录需要移除弹出框
            if (top.document.getElementById('bgDiv')) {
                parent.removeLoginDialogAfterLogon();
                //ajax刷新首页登录块
            } else {
                window.top.location.href = "index.html";
            }

        }
        return;
    }
    if (responseCode == "001") {
        alert('尊敬的客户，您的个人资料还没设置，请先设置您的个人资料！');
        window.top.location.href = 'preRegisterUpdate.html';
        return;
    }
    if (responseCode == "115") {
        alert('尊敬的客户，您的密码过于简单，为了您的帐户安全，请重新设置您的密码！');
        window.top.location.href = 'forcePassword.html';
        return;
    }
    if (responseCode == "" || responseCode == "21") {
        return;
    }
    //webservice异常
    if (responseCode == "1050000000005") {
        alert(i18n['ALERT_SYSTEM_BUSY']);
        return;
    }
    alert(i18n[responseCode]);
}
var sobj = null;
var itm = "";
function changeType(obj) {
    var opt = obj.options[obj.selectedIndex];
    if (sobj != null) {
        sobj.innerHTML = itm;
    }
    for (var i = 0; i < obj.options.length; i++) {
        if (obj.options[i].value == opt.getAttribute('parentId')) {
            itm = opt.innerHTML;
            opt.innerHTML = "&nbsp;&nbsp;" + obj.options[i].getAttribute('realtext') + "|" + opt.getAttribute('realtext');
            sobj = opt;
            break;
        }
    }
}
/*3.原search_common.js，用于头部块，彩印搜索框使用的校验js------------------------------------------------------------------------------------------*/
var doOnSearch = function() {
    var obj_content = $("topSearchKey").value.trim();
    if ("请输入关键字搜索彩印与彩印盒" == obj_content || obj_content == '') {
        alert('请您输入搜索条件！');
        return false;
    }
    return true;
}

function setCookie(sName, sValue) {
    document.cookie = sName + "=" + window.escape(sValue);
}

//获取cookie
var getCookie = function(name) {
    var strCookie = document.cookie;
    var arrCookie = strCookie.split("; ");
    for (var i = 0; i < arrCookie.length; i++) {
        var arr = arrCookie[i].split("=");
        if (arr[0] == name) {
            if (arr.length == 2) {
                return unescape(arr[1]);
            } else {
                return null;
            }
        }
    }
    return 0;
}

function setMenuFlag(name) {
    setCookie("currentMenu", name);
    if (name != "center") {
        setCookie("enablCenterCookie", "false");
    }
}

//从request请求从取url参数
function getUrlParamValue(key) {
    var uri = window.top.location.search;
    var re = new RegExp("" + key + "=([^&?]*)", "ig");
    return ((uri.match(re)) ? (uri.match(re)[0].substr(key.length + 1)) : null);
}

function checkMenuClickFlag() {
    var topdefault = getCookie("currentMenu");
    if (topdefault == null) {
        return;
    }
    topdefault = "menu_" + topdefault;
    if ($(topdefault)) {
        $(topdefault).className = "lpzdtab01";
    }
}

/*登录块校验js*/
var login = {
    show: function(requestUrl) {
    	//种植登录前路径到cookie中    
    	if(requestUrl != null){
    		setCookie("requestUrl",requestUrl);
    	}	
    	
    	   //第一个数字是高度，第二个数字是宽度
            // 第三个数字是指的弹出框在屏幕宽度的40%处开始弹出div，
            // 第四个数字125表示 距页面顶部125px，调整二值进行位置设置
        autoAlert('login.html', 300, 300, '用户登录', 40, 125);
    }
}
/*用于弹出登录框，隐藏部分div，或是关闭登录框时，显示被隐藏的div*/
function doLoginHidenDiv(isHidden) {
    var hideIds = getCookie("loginHidenIds");
    if (hideIds != null && typeof hideIds == 'string' && hideIds != "") {
        if (hideIds.indexOf(",") > 0) {
            var ids = hideIds.split(",");
            for (var id = 0; id < ids.length; id++) {
                if (ids[id] != "" && $(ids[id])) {
                    $(ids[id]).style.display = isHidden ? "none": "";
                    if ($(ids[id] + "_hiden")) {
                        $(ids[id] + "_hiden").style.display = isHidden ? "": "none";
                    }
                }
            }
        } else {
            if ($(hideIds)) {
                $(hideIds).style.display = isHidden ? "none": "";
                if ($(hideIds + "_hiden")) {
                    $(hideIds + "_hiden").style.display = isHidden ? "": "none";
                }
            }
        }
    }
}

/*搜索界面相关js*/
function drop_mouseover(pos) {
    try {
        window.clearTimeout(timer);
    } catch(e) {}
}
function drop_mouseout(pos) {
    var posSel = $(pos + "Sel").style.display;
    if (posSel == "block") {
        timer = setTimeout("drop_hide('" + pos + "')", 1000);
    }
}
function drop_hide(pos) {
    $(pos + "Sel").style.display = "none";
}
function search_show(pos, searchType, href) {
    $(pos + "SearchType").value = searchType;
    $(pos + "Sel").style.display = "none";
    $(pos + "Slected").innerHTML = href.innerHTML;
    $(pos + 'q').focus();
    var sE = $("searchExtend");
    try {
        window.clearTimeout(timer);
    } catch(e) {}
    return false;
}

var doClickSort = function(objname) {
    var obj = $(objname);
    obj.value = parseInt(obj.value) == 0 ? "2": "0";
    for (var i = 1; i <= 4; i++) {
        var one = "sortObj" + i;
        if (objname != one) {
            $(one).value = "0";
        }
    }
    $('sortForm').submit();
}
var doOnChangeFlag = function(obj) {
    var opt = obj.options[obj.selectedIndex];
    var objname = opt.getAttribute("ptm");
    $(objname).value = "0";
    doClickSort(objname);
}
var doSeniorSearch = function() {
    var obj_days = $("days").value;
    //在没有其他搜索条件的情况下，搜索条件——彩印内容不能为空
    var obj_content = $("acontent").value;
    if ((obj_days == "" || obj_days == "-1") && (/^\s*$/).test(obj_content)) {
        alert('请您输入至少一个搜索条件！');
        return false;
    }
    return true;
}

/*4.用于登录相关js*/
function onfoucs(objId) {
    $(objId).focus();
    if (objId == 'userIdField' || objId == 'passwordField') {
        hiddenImg();
    }
}
function saveFocus() {
    $("checkcode").focus();
}
function validLogin() {
    var userId = $('userIdField').value;
    var password = $('passwordField').value;
    var modelType = $('model').value;
    var checkcode;
    if ($('checkcode')) {
        checkcode = $('checkcode').value;
    } else {
        checkcode = "";
    }
    if (userId == '') {
        alert(i18n['ALERT_PHONE_EMPTY']);
        return false;
    } else if (password == '') {
        alert(i18n['ALERT_PWD_EMPTY']);
        return false;
    } else {
        var ret = !UserLogin.login(userId, password, checkcode, modelType);
        if (!ret) {
            reloadFreshCount = 0; //执行过看不清
            needRefreshRandCode = true; //当前是否需要重刷
            //$("passwordField").value = '';
            if ($("checkcode")) {
                $("checkcode").value = '';
            }
            //reLoadFreshCheckCode1();
        }
        return ret;
    }

}

/*0.刷新随机码*/
function refreshCheckCodeImageImage1() {
    var checkCodeImage2 = document.getElementById('checkCodeImage');
    if (!checkCodeImage2) return;
    checkCodeImage2.src = "csp.CheckCode?random=" + Math.random();
}

/*1.看不清时使用*/
function reLoadFreshCheckCode1() {
    refreshCheckCodeImageImage1();
    //设置已经刷新过随机码
    reloadFreshCount = reloadFreshCount + 1;
    needRefreshRandCode = false;
    runRandCodeCounter1(1); //执行定时器
    $("checkcode").value = '';
}

/*2.点击输入框时调用，如果needReloadRandCode为true表示验证码超时，需要重新获取验证才能登录*/
function checkCodeShow1() {
    if (needRefreshRandCode) {
        refreshCheckCodeImageImage1();
        haveRefreshRandCode = false;
        needRefreshRandCode = false;
        runRandCodeCounter1(2);
        $("checkcode").value = '';
    }
}

/*3.计时器，在下个周期修改状态，再次点击按扭，需要刷新随机码*/
function runRandCodeCounter1(type) {
    if (type == 1) { //表示点了看不清
        setTimeout("setNeedReloadRandCode11()", 60000);
    } else {
        setTimeout("setNeedReloadRandCode12()", 60000);
    }
}

/*4.重置刷新状态为需要刷新*/
function setNeedReloadRandCode11() {
    if (reloadFreshCount == 0) {
        return;
    }
    reloadFreshCount = reloadFreshCount - 1;
    if (reloadFreshCount == 0) {
        needRefreshRandCode = true
    }
}

/*5.重置刷新状态为需要刷新*/
function setNeedReloadRandCode12() {
    if (reloadFreshCount == 0) { //没有点击看不清按扭
        needRefreshRandCode = true;
    }
}

function modelChange() {
    var modelType = $('model').value;
    if (modelType == 1) {
        $('sendRand').style.display = '';
        $("passLabel").innerHTML="随机短信";
    } else {
        $('sendRand').style.display = 'none';
        $("passLabel").innerHTML="用户密码";
    }
}
function send() {
    var uid = $('userIdField').value;
    if (uid == null || uid == '') {
        alert(i18n['ALERT_PHONE_EMPTY']);
        return false;
    } else {
        return ! RandCode.sent(uid, "");
    }
}

function forget() {
    window.top.location.href = 'userRegister.html';
}

function showImg() {
    if ($('_rndImageDIV')) {
        $('_rndImageDIV').style.display = '';
    }
}
function hiddenImg() {
    if ($('_rndImageDIV')) {
        $('_rndImageDIV').style.display = 'none';
    }
}

/*用于第三方首页快速设置通用彩印：http://www.cmccqm.com/index.html?qm=彩印内容  通过此url，门户对此请求进行处理*/
function setSignFromUrl(isLogined) {
    var qm = getUrlParamValue("qm");
    if (qm != null && qm.length > 0) {
        if (isLogined) {
            $("signContext").value = qm;
        } else {
            login.show();
        }
    }
    siCard.blur();
    if ($("cur_num")) {
        $("cur_num").innerHTML = $("signContext").value.length;
    }
}

/**快速彩印设置框相关js*/
var siCard = {};
siCard.maxLengthTips = function() {
    return "请在这里输入您想说的通用彩印，最多可输入" + $("max_num").innerHTML + "个汉字。请勿传送非法信息，违者将自负相应法律责任。";
};
siCard.blur = function() {
    if (!$("signContext")) {
        return;
    }
    var content = $("signContext").value;
    if (content == "") {
        $("signContext").value = siCard.maxLengthTips();
    }
};
siCard.focus = function() {
    var content = $("signContext").value;
    if (content == siCard.maxLengthTips()) {
        $("signContext").value = "";
    }
};
siCard.submit = function() {
    if ($('signContext').value.trim() == '') {
        alert('请在输入框内输入您的通用彩印');
        return false;
    }
    if ($('signContext').value.trim() == siCard.maxLengthTips()) {
        alert('请在输入框内输入您的通用彩印');
        return false;
    }
    CommonSet.set('', $('signContext').value);
};
siCard.onclick = function() {
    loadTxLisnter('signContext');
    if (this.value == siCard.maxLengthTips()) {
        this.value = ''
    }
};

/*原common.js*/

function toUrl(url, content) {
    var arg = encodeURIComponent(content);
    document.location.href = url + arg;
}

/*
 reset all the form elements for button 'reset'
*/
function resetAll() {
    var frm = document.forms[0];
    try {
        for (i = frm.elements.length - 1; i >= 0; i--) {
            switch (frm.elements[i].type) {
            case 'text':
                frm.elements[i].value = "";
                break;
            case 'checkbox':
                if (frm.elements[i].name != 'cb' && frm.elements[i].name != 'acd' && frm.elements[i].name != 'clickall' && frm.elements[i].name != 'ctrlAll' && frm.elements[i].name != 'acb') {
                    frm.elements[i].checked = false;
                }
                break;
            case 'select-one':
                frm.elements[i][0].selected = true;
                break;
            case 'radio':
                if (frm.elements[i].value == '' || frm.elements[i].value == '0') {
                    frm.elements[i].checked = true;
                }
                break;
            }
        }
    } catch(exception) {}
    return true;
}
/*
说明：记录复选框全选/全不选
参数：
    v:控制复选框的值
*/
function selectAll(v) {
    var frms = document.forms;
    for (var j = 0; j < frms.length; j++) {
        var frm = document.forms[j];
        if (frm.cb != null) // 如果有记录
        {
            var len = frm.cb.length;
            if (isNaN(len)) // 单条记录
            {
                frm.cb.checked = v;
            } else // 多条记录
            {
                for (var i = 0; i < len; i++) {
                    frm.cb[i].checked = v;
                }
            }
        }
    }
}
/*
 if no checkbox is checked then not allow to excute dels
*/
function deleteCheck() {
    var frm = document.forms[0];
    var boolflag = false;
    if (frm.cb != null) {
        var len = frm.cb.length;
        if (isNaN(len)) {
            boolflag = frm.cb.checked;
        } else {
            for (var i = 0; i < len; i++) {
                if (frm.cb[i].checked == true) {
                    boolflag = true;
                    break;
                }
            }
        }
    }
    if (boolflag == false) {
        alert('至少选择一条记录删除！');
    } else {
        if (!confirm('确认删除吗？')) boolflag = false;
    }
    return boolflag;
}
/*
 if no checkbox is checked then not allow to excute dels
*/
function dels(actionName) {
    if (deleteCheck()) {
        document.forms[0].action = actionName;
        document.forms[0].submit();
    }
}
//一次只删除一条记录 
function deleteOneCheck() {
    var frm = document.forms[0];
    var boolflag = false;
    var checkNum = 0;
    if (frm.cb != null) {
        var len = frm.cb.length;
        if (isNaN(len)) {
            boolflag = frm.cb.checked;
        } else {
            for (var i = 0; i < len; i++) {
                if (frm.cb[i].checked == true) {
                    boolflag = true;
                    checkNum++;
                }
            }
        }
    }
    if (boolflag == false && checkNum == 0) {
        alert('至少选择一条记录删除！');
    } else {
        if (!confirm('确认删除吗？')) boolflag = false;
    }
    return boolflag;
}

var isclickedDel=false;

function checkDumpDelClick(){
    if(isclickedDel){
        alert("您的请求已经提交！");
        return true;
    }
    return false;
}

function deleteOne(actionName) {
	if(checkDumpDelClick()){//已经提交不能继续操作，ajax删除需另外处理
        return ;
	}
    if (deleteOneCheck()) {
        document.forms[0].action = actionName;
        document.forms[0].submit();
        isclickedDel=true;//标识已经提交删除
    }
}
function mySubmit(actionName) {
    document.forms[0].action = actionName;
    document.forms[0].submit();
}
function getMsgCode(formName, id) {
    document.forms[formName].action = "sendRandCode.html?user.id=" + id;
    document.forms[formName].submit();
}

function doMyAdd() {
    if (confirm(i18n['ALERT_SUBMIT_CONFIRM'])) {
        return true;
    }
    return false;
}
function doMyUpt() {
    if (confirm(i18n['ALERT_MODIFY_CONFIRM'])) {
        return true;
    }
    return false;
}

/*弹出窗口中显示iframe内容*/
var sAlert=function(url, owt, oht, otitle, ox, oy){
	sAlertBase(url,"url", owt, oht, otitle, ox, oy);
}

var sAlertContent=function(content,owt, oht, otitle, ox, oy,pageLen){
	sAlertBase(content,"txt", owt, oht, otitle, ox, oy,pageLen);
}



/*弹出窗口相关js*/
var sAlertBase = function(str,type, owt, oht, otitle, ox, oy,pageLen) {
    if ($("bgDiv")) {
        return;
    }
    //隐藏会挡住弹出框的div
    doLoginHidenDiv(true);
    //设置当前点击了弹出框
    setCookie("clickDiaglog", "true");
    //
    //oht=520;
    //owt=680;
    var msgw, msgh, bordercolor;
    msgw = owt; //提示窗口的宽度
    msgh = oht; //提示窗口的高度
    relativeHeight = 20;

    titleheight = 27; //提示窗口标题高度
    bordercolor = "#5993a7"; //提示窗口的边框颜色 
    var sWidth, sHeight;
    sWidth = screen.width; //浏览器工作区域内页面宽度 或使用 document.body.offsetWidth;//屏幕的宽度
    sHeight = getPageSize(); //屏幕高度（垂直分辨率） 
    //背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）
    bgObj = document.createElement("div"); //创建一个div对象（背景层） //动态创建元素，这里创建的是 div
    //定义div属性，即相当于(相当于，但确不是，必须对对象属性进行定义
    bgObj.setAttribute('id', 'bgDiv');
    bgObj.style.position = "absolute";
    bgObj.style.left = "0";
    bgObj.style.top = "0";
    bgObj.style.background = "white";
    bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=1,opacity=25,finishOpacity=100,startX=50,finishX=100,startY=50,finishY=100";
    bgObj.style.opacity = "0.6";
    bgObj.style.width = (sWidth - 30) + "px";
        
    if (typeof pageLen != 'undefined'&&pageLen != null) {
        sHeight = pageLen;
    }
    bgObj.style.height = sHeight + "px";
    document.body.appendChild(bgObj); //在body内添加该div对象 
    //创建一个div对象（提示框层）
    msgObj = document.createElement("div");
    //定义div属性，即相当于
    msgObj.setAttribute("id", "msgDiv");
    msgObj.setAttribute("align", "left");
    msgObj.style.background = "white";
    msgObj.style.border = "0px solid " + bordercolor;
    msgObj.style.position = "absolute";
    msgObj.style.left = ox + "%";
    msgObj.style.top = oy + getPageScroll() + "px";
    msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
    msgObj.style.width = (msgw - 5) + "px";
    msgObj.style.height = msgh + "px";
    msgObj.style.textAlign = "center";
    msgObj.style.lineHeight = "25px";

    document.body.appendChild(msgObj); //在body内添加提示框div对象msgObj
    var txt = document.createElement("div"); //创建一个p对象（提示框提示信息）
    txt.setAttribute("id", "msgTxt");
    var msg=str;
    
    if(type=='url'){
        msg = "<iframe id='configIframe' name='configIframe'  allowtransparency=true frameborder=0 scrolling='auto' src=" + str + " style='margin-left:5px;margin-right:2px;zIndex:120000' width=100% height='" + (oht - 40) + "px'></iframe>"; //来源于函数调用时的参数值 
    }else{
    	txt.style.width="100%";
    	txt.style.height=(oht - 40)+"px";
    	txt.style.zIndex=120000;
    }
    txt.innerHTML = getTipHtml(otitle, true, false, msg, owt, "pRemoveAlertBase();");
    $("msgDiv").appendChild(txt);

    function removeAlertBaseObj() { //点击标题栏触发的事件
        $("msgDiv").innerHTML = "";
        document.body.removeChild(msgObj); //删除提示框层
        document.body.removeChild(bgObj); //删除背景层Div
    }
    window.pRemoveAlertBase = function() {
        removeAlertBaseObj();
        //还原会挡住弹出框的div
        doLoginHidenDiv(false);
        setCookie("clickDiaglog", "false");
        if ("true" == getCookie("toHomeFresh")) { //表示已经登录，在关闭弹出框时，如果在首页，需要刷新登录显示区
            //登录刷新
            if ($('indexPortletBlock')) {
                ajaxFresh('portal.html?tplfile=/index/ads_right', 'indexPortletBlock');
            }
        }
    };
}

function getPageScroll() {
    var yScroll;
    if (self.pageYOffset) {
        yScroll = self.pageYOffset;
    } else if (document.documentElement && document.documentElement.scrollTop) { // Explorer 6 Strict 
        yScroll = document.documentElement.scrollTop;
    } else if (document.body) { // all other Explorers 
        yScroll = document.body.scrollTop;
    }
    arrayPageScroll = new Array('', yScroll);
    return yScroll + 100;
}
function getPageSize() {
    var xScroll, yScroll;
    if (window.innerHeight && window.scrollMaxY) {
        xScroll = document.body.scrollWidth;
        yScroll = window.innerHeight + window.scrollMaxY;
    } else if (document.body.scrollHeight > document.body.offsetHeight) { // all but Explorer Mac 
        xScroll = document.body.scrollWidth;
        yScroll = document.body.scrollHeight;
    } else { // Explorer Mac...would also work in Explorer 6 Strict, Mozilla and Safari 
        xScroll = document.body.offsetWidth;
        yScroll = document.body.offsetHeight;
    }
    var windowWidth, windowHeight;
    if (self.innerHeight) { // all except Explorer 
        windowWidth = self.innerWidth;
        windowHeight = self.innerHeight;
    } else if (document.documentElement && document.documentElement.clientHeight) { // Explorer 6 Strict Mode 
        windowWidth = document.documentElement.clientWidth;
        windowHeight = document.documentElement.clientHeight;
    } else if (document.body) { // other Explorers 
        windowWidth = document.body.clientWidth;
        windowHeight = document.body.clientHeight;
    }
    // for small pages with total height less then height of the viewport 
    if (yScroll < windowHeight) {
        pageHeight = windowHeight;
    } else {
        pageHeight = yScroll;
    }
    if (xScroll < windowWidth) {
        pageWidth = windowWidth;
    } else {
        pageWidth = xScroll;
    }
    arrayPageSize = new Array(pageWidth, pageHeight, windowWidth, windowHeight);
    return pageHeight;
}



/*用于显示登录框，边框在登录框所有页面*/
var autoAlert = function(str, oht, owt, otitle, ox, oy) {
    if ($("bgDiv")) {
        return;
    }
    doLoginHidenDiv(true);
    if ("true" == getCookie("clickDiaglog")) { //彩印盒对话框中登录框，显示位置需要上移180
        oy = oy - 220;
    }
    var msgw, msgh, bordercolor;
    msgw = owt; //提示窗口的宽度
    msgh = oht; //提示窗口的高度
    relativeHeight = 20;

    titleheight = 27; //提示窗口标题高度
    bordercolor = "#5993a7"; //提示窗口的边框颜色 
    var sWidth, sHeight;
    sWidth = screen.width; //浏览器工作区域内页面宽度 或使用 screen.width//屏幕的宽度
    sHeight = getPageSize(); //屏幕高度（垂直分辨率） 
    //背景层（大小与窗口有效区域相同，即当弹出对话框时，背景显示为放射状透明灰色）
    bgObj = document.createElement("div"); //创建一个div对象（背景层） //动态创建元素，这里创建的是 div
    //定义div属性，即相当于(相当于，但确不是，必须对对象属性进行定义
    //<div id="bgDiv" style="position:absolute; top:0; background-color:#777; filter:progid:DXImagesTransform.Microsoft.Alpha(style=3,opacity=25,finishOpacity=75); opacity:0.6; left:0; width:918px; height:768px; z-index:10000;"></div>
    bgObj.setAttribute('id', 'bgDiv');
    bgObj.style.position = "absolute";
    bgObj.style.left = "0";
    bgObj.style.top = "0";
    bgObj.style.background = "white";
    bgObj.style.filter = "progid:DXImageTransform.Microsoft.Alpha(style=1,opacity=25,finishOpacity=100,startX=50,finishX=100,startY=50,finishY=100";
    bgObj.style.opacity = "0.6";
    bgObj.style.width = (sWidth - 30) + "px";
    bgObj.style.height = sHeight + "px";
    document.body.appendChild(bgObj); //在body内添加该div对象 
    //创建一个div对象（提示框层）
    msgObj = document.createElement("div");
    //定义div属性，即相当于
    //<div id="msgDiv" align="center" style="background-color:white; border:1px solid #336699; position:absolute; left:50%; top:50%; font:12px/1.6em Verdana,Geneva,Arial,Helvetica,sans-serif; margin-left:-225px; margin-top:npx; width:400px; height:100px; text-align:center; line-height:25px; z-index:100001;"></div>
    msgObj.setAttribute("id", "msgDiv");
    msgObj.setAttribute("align", "left");
    msgObj.style.background = "white";
    msgObj.style.border = "0px solid " + bordercolor;
    msgObj.style.position = "absolute";
    msgObj.style.left = ox + "%";
    msgObj.style.top = oy + getPageScroll() + "px";
    msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
    msgObj.style.width = msgw + "px";
    msgObj.style.height = msgh + "px";
    msgObj.style.textAlign = "center";
    //msgObj.style.lineHeight ="25px"; 
    document.body.appendChild(msgObj); //在body内添加提示框div对象msgObj

    var txt = document.createElement("div"); //创建一个p对象（提示框提示信息）
    txt.setAttribute("id", "msgTxt");
    txt.innerHTML = "<iframe id='configIframe' name='configIframe'  allowtransparency=true frameborder=0 scrolling='no' src=" + str + " style='zIndex:120000' width='" + owt + "px' height='" + oht + "px'></iframe>"; //来源于函数调用时的参数值 
    $("msgDiv").appendChild(txt);

    function removeLoginAlertObj() { //点击标题栏触发的事件

        $("msgDiv").innerHTML = "";
        document.body.removeChild(msgObj); //删除提示框层
        document.body.removeChild(bgObj); //删除背景层Div

        //显示被隐藏的div
        doLoginHidenDiv(false);
    }
    window.removeLoginDialog = function() {
        removeLoginAlertObj();
        //将登录前URL从cookie中除去
        setCookie("requestUrl", "");
    };
    window.removeLoginDialogAfterLogon = function(message) {
       	removeLoginAlertObj();
        showTipsAlertAtFocus('tip_logion','系统提示',false,false,'<div style=\"margin-top:30px;width:280px;height:50px;font-size:14px;color:#0167B2;font-weight:bold;\">&nbsp;&nbsp;&nbsp;&nbsp;'+message+'</div>',300,150,'page_div',300,200);
        setTimeout("loginProcess()", 1500);
    };
        
};

//登录后的操作,路增加
function loginProcess(){
	//关闭系统信息
	removeTipsAlert('tip_logion');
	 //取得登录前所要访问的URL，登录成功后访问原来的URL
	 var requestUrl = getCookie("requestUrl");            			
	 if(requestUrl != null && requestUrl.length > 0){
		//清空requestUrl
		 setCookie("requestUrl","");
		 window.top.location.href = requestUrl;
	 }	 
}

function dologinProcess(){
        removeTipsAlert('tip_logion');
        setCookie("toHomeFresh", "true");
        //登录刷新
        if ($('indexPortletBlock')) {
            ajaxFresh('portal.html?tplfile=/index/ads_right', 'indexPortletBlock');
        }
        if ($('topic_unloginInfo')) {
            $('topic_unloginInfo').style.display = "none";
            $('topic_loginInfo').style.display = "";
        }
        //继续用户操作，从cookie中取值，如果是其它界面需要进行相应操作，如：使用彩印，收藏，投票，  彩印盒的使用与收藏，从cookie中取，当点击
        var action = getCookie("cspClickAction");
        if ("commonSetByIndex.html" == action) {
            commonsetRsponse("0", getCookie("cspClickAction_rule.id"), getCookie("cspClickAction_rule.content"), true);
        }
        if ("vote.html" == action) {
            //设置用户操作动作
            Vote.vote(getCookie("cspClickAction_id"));
        }
        if ("collect.html" == action) {
            //设置用户操作动作
            Collection.add(getCookie("cspClickAction_id"));
        }
        //彩印盒
        if ("collectPackage.html" == action) {
            //设置用户操作动作
            SignPackage.collect(getCookie("cspClickAction_signPackageId"));
        }
        //专属彩印设置
        if ("toCustomSignRule.html" == action) {
            var url = "toCustomSignRule.html?random=" + Math.random();
            var id=getCookie("cspClickAction_rule.id");
            var content=getCookie("cspClickAction_rule.content");
            var packageId=getCookie("cspClickAction_signPackageId");
            if(isNotBlank(id)){
            url=url+"&rule.id=" + id ;
            }
            if(isNotBlank(content)){
            url=url+"&rule.content=" + content;
            }
            if(isNotBlank(packageId)){
            url=url+"&rule.signPackageId=" + packageId; 
            }
            setCookie("cspClickAction", "");
            setCookie("cspClickAction_rule.content", "");
            setCookie("cspClickAction_rule.id", "");
            setCookie("cspClickAction_signPackageId",""); 
            sAlert(url, 480, 275, '专属彩印设置', 30, 150);
            return ;
        }
        //
        if ("setSignPackageByIndex.html" == action) {
            //设置用户操作动作
            commonsetRsponse2("0", getCookie("cspClickAction_signPackage.id"));
        }
        //跳转到我的中心子页面
        if ("enterMycenter" == action) {
            setCookie("cspClickAction", "");
            window.location = getCookie("cspClickAction_url");
        }
        setCookie("cspClickAction", "");

        var redirectUrl = getCookie("redirectUrl");
        if (redirectUrl != null && redirectUrl != "") {
            setCookie("redirectUrl", "");
            window.parent.location = redirectUrl;
            return;
        }
      
}

/*关闭提示信息弹出框*/
var removeTipsAlert = function(type) {
    var obj = $("msgDiv_" + type);

    function removeTipsAlertObj() {
        document.body.removeChild(obj);
    }
    window.pRemoveTipsAlert = function() {
        removeTipsAlertObj();
    };

    if (obj) {
        removeTipsAlertObj();
    }
}

/*获取一个控件的光标位置*/
function getFocus(id) {
    var obj = $(id);
    var oPos = new Object();
    oPos.x = obj.offsetLeft;
    oPos.y = obj.offsetTop;
    
    while (obj = obj.offsetParent) {
        oPos.x += obj.offsetLeft;
        oPos.y += obj.offsetTop;
    }
    
    return oPos; //返回对象
}

/*显示提示信息弹出框：
使用说明
type唯一标识一个弹出框，
msg表示提示信息
width与height二者必须要一个值不能为0的数字
focusId表示定位光标的控件ID
offsetLeft,offsetTop，都可为0，可为正负数，表示相对于光标位置的相对位置
*/
var showTipsAlertAtFocus = function(type, title, titleVisiable, toolbarVisiable, msg, width, height, focusId, offsetLeft, offsetTop) {
    if ($("msgDiv_" + type)) {
        return;
    }
    if (width < 200) {
        width = 200;
    }   
    var msgObj = document.createElement("div");
    msgObj.setAttribute("id", "msgDiv_" + type);
    msgObj.setAttribute("align", "center");
    msgObj.style.position = "absolute";
    var focusObj = getFocus(focusId); //获取光标位置
    if (focusObj) {
        msgObj.style.left = (focusObj.x + offsetLeft) + "px";
        msgObj.style.top = (focusObj.y + offsetTop) + "px";
    }else{
    	msgObj.style.left = "40%";
        msgObj.style.top = offsetTop + getPageScroll() + "px";
    }     
 
    msgObj.style.font = "12px/1.6em Verdana, Geneva, Arial, Helvetica, sans-serif";
    if (width != 0) {
        msgObj.style.width = width + "px";
    }
    if (height != 0) {
        msgObj.style.height = height + "px";
        msgObj.style.textAlign = "center";
    }

    function removeTipsObj() { //点击标题栏触发的事件
        document.body.removeChild(msgObj); //删除提示框层
    }
    window.pRemoveTipsAlertAtFocus = function() {
        removeTipsObj();
    };
    document.body.appendChild(msgObj); //在body内添加提示框div对象msgObj

    var txt = document.createElement("div"); //创建一个p对象（提示框提示信息）
    //定义p的属性，即相当于
    txt.style.margin = "1em 0";
    txt.setAttribute("id", "msgTxt_" + type);
    txt.style.textAlign = "center";
    txt.innerHTML = getTipHtml(title, titleVisiable, toolbarVisiable, msg, width, "pRemoveTipsAlertAtFocus();");
    $("msgDiv_" + type).appendChild(txt); //在提示框div中添加提示信息对象txt
}

function getTipHtml(title, titleVisiable, toolbarVisiable, msg, width, onCloseMethod) {
    //新弹出框，可设置宽度
    var newTipHtml = '<div  class=\"fc\"  style=\"width:' + width + 'px;\">';
    
    if (title == null || title.lenght == 0) {
        title = "系统提示";
    }
    newTipHtml += '<div class=\"fc1\" style=\"width:100%\"><div class=\"fc1_1\" style=\"width:' + (width - 40) + 'px; padding-left:10px;\">' + title + '</div>';

    var dir=getCookie('currentLocation');
    if(dir==0){
    	dir="gd/";
    }
    newTipHtml += '<div class=\"fc1_2\"><a href=\"javascript:' + onCloseMethod + '\"><img src=\"'+'images/close.gif\" title=\"点击关闭弹出框\" border=\"0\" /></a></div>';
    newTipHtml += '</div><div class=\"fc2\" style=\"width:' + (width - 6) + 'px;\">';
    newTipHtml += '<div class=\"fc3_2\" align=\"left\">' + msg + '</div>';
    if (toolbarVisiable) {
        newTipHtml += '<div class=\"fc3_3\" style=\"padding-left:' + (width / 2 - 25) + 'px;\">';
        newTipHtml += "<div class=\"botton_bg\"  onclick=\"" + onCloseMethod + "\" onmouseover=\"this.className='botton_bg_over'\" onmouseout=\"this.className='botton_bg'\"><a href=\"javascript:void(0)\" class=\"link000\">确定</a></div>";
        newTipHtml += '</div>';
    }
    newTipHtml += '</div></div>';

    return newTipHtml;
}

function txChange(textAreaId, cur_numId, max_numId, id) {
    if (typeof cur_numId == 'undefined' || cur_numId == null || cur_numId == '') {
        cur_numId = "cur_num";
    }
    if (typeof max_numId == 'undefined' || max_numId == null || max_numId == '') {
        max_numId = "max_num";
    }
    if (typeof textAreaId == 'undefined' || textAreaId == null || textAreaId == '') {
        textAreaId = "signContext";
    }
    if (typeof id == 'undefined' || id == null) {
        id = "";
    }
    var cur_num = document.getElementById(cur_numId + id);
    if (!cur_num) {
        return;
    }
    var cur_value = document.getElementById(textAreaId + id);
    var max_num = parseInt(document.getElementById(max_numId + id).innerHTML);
    if (cur_value.value.length > max_num) {
        cur_value.value = cur_value.value.substring(0, max_num);
    }
    var cur_length = cur_value.value.length;
    cur_num.innerHTML = cur_length;
}

function AttachTextAreaEvent(target, textAreaId, cur_numId, max_numId, id) {
    if (window.attachEvent) { //IE
        target.attachEvent("onpropertychange",
        function() {
            txChange(textAreaId, cur_numId, max_numId, id);
        });
    } else { //FF
        target.addEventListener("input",
        function() {
            txChange(textAreaId, cur_numId, max_numId, id);
        },
        false);
    }
}
//--页面加载时必须指定，需要进行字数校验的输入框相关参数
function loadTxLisnter(textAreaId, cur_numId, max_numId, multiSize) {

    if (typeof cur_numId == 'undefined' || cur_numId == null || cur_numId == '') {
        cur_numId = "cur_num";
    }
    if (typeof max_numId == 'undefined' || max_numId == null || max_numId == '') {
        max_numId = "max_num";
    }
    if (typeof textAreaId == 'undefined' || textAreaId == null || textAreaId == '') {
        textAreaId = "signContext";
    }
    if (typeof multiSize == 'undefined' || multiSize == null || multiSize <= 1) {
        if (!$(textAreaId)) {
            return;
        }
        AttachTextAreaEvent(document.getElementById(textAreaId), textAreaId, cur_numId, max_numId, "");
        txChange(textAreaId, cur_numId, max_numId, "");
        return;
    }
    for (var i = 1; i <= multiSize; i++) {
        AttachTextAreaEvent(document.getElementById(textAreaId + i), textAreaId, cur_numId, max_numId, i);
        txChange(textAreaId, cur_numId, max_numId, id)
    }
}

function checkPhone(phone){
    return  (/^1\d{10}$/).test(phone.trim());
}


function commonBatchDel(frm, selectOneTips,delCheckTips){
	var ids=new Array();
    var boolflag = false;
    var checkNum = 0;
    if (frm != null) {
        var len = frm.length;
        if (isNaN(len)) {
            if(frm.value&&frm.checked){
                boolflag = true;
                    ids[0]=frm.value;
                    checkNum++;
            }else{
            boolflag = frm.checked;
            }
        } else {
            for (var i = 0; i < len; i++) {
                if (frm[i].checked == true) {
                    boolflag = true;
                    ids[checkNum]=frm[i].value;
                    checkNum++;
                }
            }
        }
    }
    if (boolflag == false && checkNum == 0) {
    	if (typeof selectOneTips == 'undefined' || selectOneTips == null || selectOneTips == '') {
    	selectOneTips='请至少选择一条记录进行删除！';
    	}
        alert(selectOneTips);
        return "";
    } else {
    	if (typeof delTips == 'undefined' || delTips == null || delTips == '') {
    	delTips='您确认删除所选记录吗？';
    	}
        if (confirm(delTips)){
            return ids.toString();
        } else{
        	return "";
        }
    }
}


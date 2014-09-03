<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Frameset//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-frameset.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>后台管理系统</title>
</head>

<frameset rows="112,*"  cols="*" frameborder="no" border="0" framespacing="0">
  <frame src="top.html" name="topFrame" scrolling="no" noresize="noresize" id="topFrame" title="topFrame" />
<frameset name="btmframe" cols="190,10,*" frameborder=0>
	<frame name="leftFrame" src="left_1.html"scrolling="yes" noresize="noresize" id="leftFrame" title="leftFrame" />
	<frame src="center.html" noresize />
	<frame name="mainFrame" src="view_activity.html" frameborder="no" scrolling="yes" id="mainFrame" title="mainFrame">
</frameset>
</frameset>
<noframes><body>
</body>
</noframes>

</html>
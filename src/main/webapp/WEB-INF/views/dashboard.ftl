<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>


<@layout.block name="css_head" type="append">
<link type="text/css" rel="stylesheet" href="<@c.url value="/resources/css/dashboard.css" />"
      media="screen,projection"/>
</@layout.block>

<@layout.put block="js_head" type="append">
<script type="text/javascript" src="<@c.url value="/resources/js/dashboard.js" />"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
</@layout.put>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="menu.dashboard.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">
    <h1>Dashboard</h1>
    <div class="row">
        <div class="col s6">
            <div class="chart" id="responseTimeChart"></div>
        </div>
    </div>
    </@layout.put>
</@layout.extends>

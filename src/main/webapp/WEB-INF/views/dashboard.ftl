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

<@layout.extends name="menu.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>

    <@layout.put block="content" type="replace">
    <h1>Dashboard</h1>
    <div class="row">
        <div class="col s6">
            <div class="chart" id="responseTimeChart"></div>
            <div class="chart" id="violationsChart"></div>
        </div>
        <div class="col s6">
            <h3>Violations</h3>
            <table class="responsive-table striped violations">
                <thead>
                <tr>
                    <th data-field="project">Project</th>
                    <th data-field="service">Instance</th>
                    <th data-field="datetime">Time</th>
                    <th data-field="message">Message</th>
                </tr>
                </thead>

                <#list projects as project>
                    <#list project.instances as instance>
                        <#list instance.violations as violation>
                            <tr>
                                <td><a href="/project/show/${project.id}" class="waves-effect waves-teal">${project.name}</a></td>
                                <td><a href="${instance.url}" class="waves-effect waves-teal">${instance.type}</a></td>
                                <td>${violation.dateTime}</td>
                                <td>${violation.message}</td>
                            </tr>
                        </#list>
                    </#list>
                </#list>
            </table>
        </div>
    </div>
    </@layout.put>
</@layout.extends>

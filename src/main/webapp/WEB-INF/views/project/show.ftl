<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="js_head" type="append">
    <script type="text/javascript" src="<@c.url value="/resources/js/project/show.js" />"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <div class="row">
        <div class="col s12">
            <ul class="tabs">
                <li class="tab col s3"><a class="active" href="#dashboard">Dashboard</a></li>
                <li class="tab col s3"><a href="#info">Info</a></li>
                <li class="tab col s3"><a href="#instances">Instances</a></li>
            </ul>
        </div>
        <div id="dashboard">
            <h2>${project.name}</h2>
            <div class="row">
                <div><img class="serviceLogo" src="<@c.url value="/resources/img/git.png" />"></div>
                <div><img class="serviceLogo" src="<@c.url value="/resources/img/jira.png" />"></div>
                <div><img class="serviceLogo" src="<@c.url value="/resources/img/jenkins.png" />"></div>
            </div>

            <div class="row">
                <div class="col s4 left-align">
                    <h3>Services</h3>
                    <table class="responsive-table striped">
                        <thead>
                        <tr>
                        <#--<th data-field="service">Service</th>-->
                            <th data-field="status">Status</th>
                            <th data-field="url">Url</th>
                        </tr>
                        </thead>

                        <#list project.services as service>
                            <tr>
                                <td>${service.status}</td>
                                <td>${service.url}</td>
                            </tr>
                        </#list>
                    </table>
                </div>
                <div class="col s8 left-align">
                    <h3>Description</h3>

                    <p>
                    ${project.description}
                    </p>
                </div>
            </div>
            <div class="row">
                <h3>Violations</h3>
                <table class="responsive-table striped">
                    <thead>
                    <tr>
                        <th data-field="service">Instance</th>
                        <th data-field="datetime">Time</th>
                        <th data-field="url">Url</th>
                        <th data-field="message">Message</th>
                    </tr>
                    </thead>

                    <#list project.instances as instance>
                        <#list instance.violations as violation>
                            <tr>
                                <td>${instance.type}</td>
                                <td>${violation.dateTime}</td>
                                <td>${violation.url}</td>
                                <td>${violation.message}</td>
                            </tr>
                        </#list>
                    </#list>
                </table>
            </div>
            <div class="row">
                <div id="container" style="min-width: 310px; height: 400px; margin: 0 auto"></div>
            </div>
        </div>
        <div id="info" class="col s12">
            <form class="col m4" action="<@c.url value="/project/edit/${project.id}" />" method="GET">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <div class="row">
                    <div class="input-field ">
                        <input id="name" type="text" name="name" class="validate" value="${project.name}" disabled>
                        <label for="name">Name</label>
                    </div>
                </div>
                <div class="row">
                    <div class="input-field ">
                        <input id="description" type="text" name="description" class="validate"
                               value="${project.description}" disabled>
                        <label for="description">Description</label>
                    </div>
                </div>
                <button class="btn waves-effect waves-light blue-grey lighten-1" type="submit" name="action">Edit
                    <i class="mdi-content-send right"></i>
                </button>
            </form>
        </div>
        <div id="instances" class="col s12">
            <table class="responsive-table striped">
                <thead>
                <tr>
                    <th data-field="status">Status</th>
                    <th data-field="url">Url</th>
                    <th data-field="type">Type</th>
                    <th data-field="version">Version</th>
                </tr>
                </thead>
                <#list project.instances as instance>
                    <tr>
                        <td>${instance.status}</td>
                        <td>${instance.url}</td>
                        <td>${instance.type}</td>
                        <td>${instance.version}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </div>
    </@layout.put>
</@layout.extends>

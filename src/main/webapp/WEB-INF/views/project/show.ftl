<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="menu.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="js_head" type="append">
    <script type="text/javascript" src="<@c.url value="/resources/js/project/show.js" />"></script>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <div class="row">
        <div class="col s12">
            <ul class="tabs">
                <li class="tab col s3"><a class="active" href="#test1">Dashboard</a></li>
                <li class="tab col s3"><a href="#test2">Info</a></li>
                <li class="tab col s3"><a href="#test3">Instances</a></li>
            </ul>
        </div>
        <div class="row" id="test1">
            <div class="col s4 left-align">
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
                <h2>Description</h2>

                <p>
                ${project.description}
                </p>
            </div>
        </div>
        <div id="test2" class="col s12">
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
                <button class="btn waves-effect waves-light" type="submit" name="action">Edit
                    <i class="mdi-content-send right"></i>
                </button>
            </form>
        </div>
        <div id="test3" class="col s12">
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

<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Projects</@layout.put>
    <@layout.put block="menu.index.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Projects
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                    <thead>
                    <tr>
                        <th data-field="name">Name</th>
                        <th data-field="instances">Instances</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list projects as project>
                        <tr>
                            <td>
                                <a href="/project/${project.id}"
                                   class="waves-effect waves-teal">${project.name}</a>
                                <p>
                                    <#list project.services as service>
                                        <a href="${service.url}">
                                            <img class="serviceLogo" src="<@c.url value="/resources/img/service/${service.type}.png"/>"/>
                                        </a>
                                    </#list>
                                </p>
                            </td>
                            <td>
                                <#list project.instances as instance>
                                        <div class="list-group-item">
                                            <#if instance.status == "GOOD">
                                                <span class="label label-success">&nbsp;</span>
                                            <#elseif instance.status == "BAD">
                                                <span class="label label-danger">&nbsp;</span>
                                            <#else>
                                                <span class="label label-default">&nbsp;</span>
                                            </#if>
                                            <span class="badge">${instance.version}</span>
                                            <div class="instanceType">${instance.type}</div>
                                            <a href="${instance.url}">${instance.url}</a>
                                            <a href="<@c.url value='/project/${project.id}/instance/${instance.id}/edit' />"><i class="fa fa-fw fa-pencil"></i></a>
                                        </div>
                                </#list>
                            </td>
                        </tr>
                        </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    </@layout.put>
</@layout.extends>

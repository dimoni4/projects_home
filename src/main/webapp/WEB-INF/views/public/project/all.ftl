<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="public/base.ftl">
    <@layout.put block="title" type="append">: Projects</@layout.put>
    <@layout.put block="menu.index.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="h1">
                Projects - Департамент разработки front-end систем
            </h1>
        </div>
    </div>

    <div class="row">
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table">
                    <tbody>
                        <#list projects as project>
                        <tr>
                            <td>
                                <span class="h3">${project.name}</span>
                                <p>
                                    <#list project.services as service>
                                        <a href="${service.url}">
                                            <img class="serviceLogo"
                                                 src="<@c.url value="/resources/img/service/${service.type}.png"/>"/>
                                        </a>
                                    </#list>
                                </p>
                            </td>
                            <td>
                                <ul>
                                    <#list project.instances as instance>
                                        <li class="list-group-item">
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
                                        </li>
                                    </#list>
                                </ul>
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

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
                        <th data-field="description">Description</th>
                        <th data-field="jenkins">Jenkins</th>
                        <th data-field="sonar">Sonar</th>
                    </tr>
                    </thead>
                    <tbody>
                        <#list projects as project>
                        <tr>
                            <td>
                                <a href="/project/show/${project.id}"
                                   class="waves-effect waves-teal">${project.name}</a>
                            </td>
                            <td>
                            ${project.description}
                            </td>
                            <td>
                                <#if project.getJenkinsUrl()?has_content>
                                    <a href="${project.getJenkinsUrl()}"><img class="serviceLogo"
                                                                              src="<@c.url value="/resources/img/jenkins.png"/>"/></a>
                                </#if>
                            </td>
                            <td>
                                <#if project.getSonarUrl()?has_content>
                                    <a href="${project.getSonarUrl()}"><img class="serviceLogo"
                                                                            src="<@c.url value="/resources/img/sonar.png"/>"/></a>
                                </#if>
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

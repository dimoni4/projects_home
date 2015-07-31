<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="menu.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>

    <@layout.put block="content" type="replace">
        <table class="responsive-table striped">
            <thead>
            <tr>
                <th data-field="name">Name</th>
                <th data-field="description">Description</th>
                <th data-field="jenkins">Jenkins</th>
                <th data-field="sonar">Sonar</th>
            </tr>
            </thead>
            <#list projects as project>
                <tr>
                    <td>
                        <a href="/project/show/${project.id}" class="waves-effect waves-teal">${project.name}</a>
                    </td>
                    <td>
                        ${project.description}
                    </td>
                    <td>
                        <#if project.getJenkinsUrl()?has_content>
                            <a href="${project.getJenkinsUrl()}"><img class="serviceLogo" src="<@c.url value="/resources/img/jenkins.png"/>"/></a>
                        </#if>
                    </td>
                    <td>
                        <#if project.getSonarUrl()?has_content>
                            <a href="${project.getSonarUrl()}"><img class="serviceLogo" src="<@c.url value="/resources/img/sonar.png"/>"/></a>
                        </#if>
                    </td>
                </tr>
            </#list>
        </table>
    </@layout.put>
</@layout.extends>

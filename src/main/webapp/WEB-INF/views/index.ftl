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
                <th data-field="url">Url</th>
                <th data-field="description">Description</th>
            </tr>
            </thead>
            <#list projects as project>
                <tr>
                    <td>${project.name}</td>
                    <td>${project.url}</td>
                    <td>${project.description}</td>
                </tr>
            </#list>
        </table>
    </@layout.put>
</@layout.extends>

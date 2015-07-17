<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>

    <@layout.put block="menu" type="replace">
    <div class="container"><a href="#" data-activates="nav-mobile"
                              class="button-collapse top-nav full hide-on-large-only"><i
            class="mdi-navigation-menu"></i></a></div>
    <ul id="nav-mobile" class="side-nav fixed" style="width: 200px;">
        <li class="logo"><a id="logo-container" href="http://materializecss.com/" class="brand-logo"></a></li>
        <#list projects as project>
            <li class="bold"><a href="project/show/${project.id}" class="waves-effect waves-teal">${project.name}</a></li>
        </#list>
    </ul>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <main>
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
    </main>
    </@layout.put>
</@layout.extends>

<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>

    <@layout.put block="menu" type="replace">
    <div class="container"><a href="#" data-activates="nav-mobile"
                              class="button-collapse top-nav full hide-on-large-only"><i
            class="mdi-navigation-menu"></i></a></div>
    <ul id="nav-mobile" class="collection side-nav fixed" style="width: 200px;">
        <li class="logo"><a id="logo-container" href="<@c.url value='/index'/>" class="brand-logo"></a></li>
        <#list projects as project>
            <li>
                <a href="/project/show/${project.id}" class="waves-effect waves-teal">
                    ${project.name}
                </a>
            </li>
        </#list>
        <li class="logo">
            <a class="btn-medium waves-effect waves-light" href="<@c.url value='/project/create'/>">Add project</a>
        </li>
    </ul>
    </@layout.put>
</@layout.extends>

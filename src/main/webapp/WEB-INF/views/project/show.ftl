<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="index.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>

    <@layout.put block="content" type="replace">
    <main>
    ${project.name}
        ${project.url}
        ${project.description}
    </main>
    </@layout.put>
</@layout.extends>

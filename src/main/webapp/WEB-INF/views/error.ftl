<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="content" type="replace">
    <h1>Some error happened!</h1>

    <h2>${exception}</h2>
    <h3>${message}</h3>
    </@layout.put>
</@layout.extends>

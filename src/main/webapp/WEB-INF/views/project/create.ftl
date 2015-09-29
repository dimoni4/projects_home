<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="menu.project.create.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">
    <div class="row">
        <form class="col offset-m4 m4" action="<@c.url value='/project/create' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="row">
                <div class="input-field ">
                    <input id="name" type="text" name="name" class="validate">
                    <label for="name">Name</label>
                </div>
            </div>
            <div class="row">
                <div class="input-field ">
                    <input id="description" type="text" name="description" class="validate">
                    <label for="description">Description</label>
                </div>
            </div>
            <button class="btn waves-effect waves-light blue-grey lighten-1" type="submit" name="action">Save
                <i class="mdi-content-send right"></i>
            </button>
        </form>
    </div>
    </@layout.put>
</@layout.extends>

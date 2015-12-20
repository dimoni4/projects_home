<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create project</@layout.put>
    <@layout.put block="menu.project.create.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">


    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Create instance
            </h1>
        </div>
    </div>


    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/instance/create' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label for="name">Project name</label>
                <input id="name" type="text" name="name" class="validate">
            </div>
            <div class="form-group">
                <label for="description">Project description</label>
                <input  id="description" type="text" name="description"  class="validate">
            </div>

            <button type="submit" class="btn btn-default">Save</button>
        </form>
    </div>
    </@layout.put>
</@layout.extends>

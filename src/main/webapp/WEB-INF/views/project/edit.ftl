<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Edit ${project.name} </@layout.put>

    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Edit project ${project.name}
            </h1>
        </div>
    </div>

    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/project/${project.id}/edit' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">Project name</label>
                <input id="name" type="text" name="name" class="validate col-sm-3" value="${project.name}">
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-3 control-label">Project description</label>
                <input id="description" type="text" name="description" class="validate col-sm-3"
                       value="${project.description}">
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-3">
                    <button type="submit" class="btn btn-default">Save</button>
                </div>
            </div>
        </form>
    </div>
    </@layout.put>
</@layout.extends>

<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Edit ${service.type} </@layout.put>

    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Edit service ${service.type}
            </h1>
        </div>

        <ol class="breadcrumb">
            <li><a href="<@c.url value='/project/all/' />">Projects</a></li>
            <li><a href="<@c.url value='/project/${service.project.id}' />">${service.project.name}</a></li>
            <li>${service.url}</li>
            <li class="active">Edit</li>
        </ol>
    </div>

    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/project/${service.project.id}/service/${service.id}/edit' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">URL</label>
                <input id="url" type="text" name="url" class="validate col-sm-3" value="${service.url}">
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

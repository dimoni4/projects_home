<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Edit ${instance.url} </@layout.put>

    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Edit instance
            </h1>
        </div>

        <ol class="breadcrumb">
            <li><a href="<@c.url value='/projects/' />">Projects</a></li>
            <li><a href="<@c.url value='/project/show/' />${instance.project.id}">${instance.project.name}</a></li>
            <li>${instance.url}</li>
            <li class="active">Edit</li>
        </ol>
    </div>

    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/instance/edit/${instance.id}' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <div class="form-group">
                <label for="url">URL</label>
                <input id="url" type="text" name="url" class="validate" value="${instance.url}">
            </div>
            <div class="form-group">
                <label for="description">Project description</label>
                <input  id="description" type="text" name="description"  class="validate" value="${instance.description}">
            </div>

            <button type="submit" class="btn btn-default">Save</button>
        </form>
    </div>
    </@layout.put>
</@layout.extends>

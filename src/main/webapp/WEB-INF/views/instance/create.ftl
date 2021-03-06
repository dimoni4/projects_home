<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create instance</@layout.put>
    <@layout.put block="menu.project.create.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">


    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Create instance
            </h1>
        </div>

        <ol class="breadcrumb">
            <li><a href="<@c.url value='/project/all/' />">Projects</a></li>
            <li><a href="<@c.url value='/project/${project.id}'/>">${project.name}</a></li>
            <li class="active">Create instance</li>
        </ol>
    </div>


    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/project/${project.id}/instance/create' />"
              method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="projectId" value="${project.id}"/>

            <div class="form-group">
                <label for="url" class="col-sm-3 control-label">URL</label>
                <input id="url" type="text" name="url" class="validate col-sm-3">
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="type">Type</label>

                <div class="col-sm-3">
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeTest" value="TEST" checked>
                            TEST
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeStage" value="STAGE">
                            STAGE
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeProduction" value="PRODUCTION">
                            PRODUCTION
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="description" class="col-sm-3 control-label">Instance description</label>
                <input id="description" type="text" name="description" class="validate col-sm-3">
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="checkCreteria.checkType">Check type</label>

                <div class="col-sm-3">
                    <div class="radio">
                        <label>
                            <input type="radio" name="checkCreteria.checkType" id="typeWord" value="NONE" checked>
                            None
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="checkCreteria.checkType" id="typeWord" value="SEARCH_WORD">
                            Search for word
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="checkCreteria.checkType" id="typeResponseCode" value="HTTP_RESPONSE_CODE">
                            Response code
                        </label>
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="checkWord" class="col-sm-3 control-label">Check value</label>
                <input id="checkCreteria.checkWord" type="text" name="checkCreteria.checkWord" class="validate col-sm-3">
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

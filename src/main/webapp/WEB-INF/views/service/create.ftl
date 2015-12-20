<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Create service</@layout.put>
    <@layout.put block="menu.project.create.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Create service
            </h1>
        </div>
    </div>

    <div class="row">
        <form role="form" class="form-horizontal" action="<@c.url value='/service/create' />" method="POST">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <div class="form-group">
                <label for="url" class="col-sm-3 control-label">URL</label>
                <input id="url" type="text" name="url" class="validate col-sm-3">
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label" for="type">Type</label>

                <div class="col-sm-3">
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeSonar" value="SONAR">
                            SONAR
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeJenins" value="JENINS">
                            Jenins
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeRepository" value="REPOSITORY">
                            Repository
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="type" id="typeLog" value="LOG">
                            Log
                        </label>
                    </div>
                </div>
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

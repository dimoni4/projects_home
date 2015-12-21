<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: ${project.name}</@layout.put>
    <@layout.put block="menu.project.active">class="active-menu"</@layout.put>
    <@layout.put block="js_head" type="append">
    <script type="text/javascript" src="<@c.url value="/resources/js/project/show.js" />"></script>
    <script src="http://code.highcharts.com/highcharts.js"></script>
    </@layout.put>

    <@layout.put block="content" type="replace">
    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
            ${project.name}
                <small>
                    <a href="<@c.url value='/project/${project.id}/edit' />"><i class="fa fa-lg fa-pencil"></i></a>
                </small>
            </h1>

            <ol class="breadcrumb">
                <li><a href="<@c.url value='/project/all' />">Projects</a></li>
                <li class="active">${project.name}</li>
            </ol>
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Description
                </div>
                <div class="panel-body">
                ${project.description}
                </div>
            </div>

        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Instances
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.instances as instance>
                            <a href="<@c.url value='/project/${project.id}/instance/${instance.id}' />"
                               class="list-group-item">
                                <span class="badge">${instance.version}</span>
                                <i class="fa fa-fw fa-comment"></i> ${instance.type} ${instance.url}
                            </a>
                        </#list>
                    </div>
                    <a href="<@c.url value='/project/${project.id}/instance/create' />">
                        <button type="submit" class="btn btn-default">
                            <i class="fa fa-fw fa-plus"></i>
                        </button>
                    </a>
                </div>
            </div>
        </div>
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Services
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.services as service>
                            <a href="${service.url}" class="list-group-item">
                                <img class="serviceLogo"
                                     src="<@c.url value="/resources/img/service/${service.type}.png"/>"/> ${service.type}

                                <a href="<@c.url value='/project/${project.id}/service/${service.id}/edit' />">
                                    <i class="fa fa-fw fa-pencil"></i>
                                </a>
                            </a>
                        </#list>
                    </div>
                    <a href="<@c.url value='/project/${project.id}/service/create' />">
                        <button type="submit" class="btn btn-default">
                            <i class="fa fa-fw fa-plus"></i>
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Violations
                </div>
                <div class="panel-body">
                    <div class="list-group">
                        <#list project.instances as instance>
                            <#list instance.violations as violation>
                                <a href="#" class="list-group-item">
                                    <span class="badge">${instance.type}</span>
                                    <i class="fa fa-fw fa-comment"></i>${violation.dateTime} ${violation.message}
                                </a>
                            </#list>
                        </#list>
                    </div>
                </div>
            </div>

        </div>
    </div>
    </@layout.put>
</@layout.extends>

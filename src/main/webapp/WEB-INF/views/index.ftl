<#assign c=JspTaglibs["http://java.sun.com/jsp/jstl/core"]>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]>
<#assign s=JspTaglibs["http://www.springframework.org/tags"]>

<@layout.extends name="base.ftl">
    <@layout.put block="title" type="append">: Index</@layout.put>
    <@layout.put block="menu.index.active">class="active-menu"</@layout.put>
    <@layout.put block="content" type="replace">

    <div class="row">
        <div class="col-md-12">
            <h1 class="page-header">
                Dashboard <small>Summary of your App</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#">Home</a></li>
                <li><a href="#">Library</a></li>
                <li class="active">Data</li>
            </ol>
        </div>
    </div>


    <!-- /. ROW  -->

    <div class="row">
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-green">
                <div class="panel-left pull-left green">
                    <i class="fa fa-bar-chart-o fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>8,457</h3>
                    <strong> Daily Visits</strong>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-blue">
                <div class="panel-left pull-left blue">
                    <i class="fa fa-shopping-cart fa-5x"></i>
                </div>

                <div class="panel-right pull-right">
                    <h3>52,160 </h3>
                    <strong> Sales</strong>

                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-red">
                <div class="panel-left pull-left red">
                    <i class="fa fa fa-comments fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>15,823 </h3>
                    <strong> Comments </strong>

                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-primary text-center no-boder bg-color-brown">
                <div class="panel-left pull-left brown">
                    <i class="fa fa-users fa-5x"></i>

                </div>
                <div class="panel-right pull-right">
                    <h3>36,752 </h3>
                    <strong>No. of Visits</strong>

                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Area Chart
                </div>
                <div class="panel-body">
                    <div id="morris-area-chart"></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-9 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Bar Chart Example
                </div>
                <div class="panel-body">
                    <div id="morris-bar-chart"></div>
                </div>
            </div>
        </div>
        <div class="col-md-3 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Donut Chart Example
                </div>
                <div class="panel-body">
                    <div id="morris-donut-chart"></div>
                </div>
            </div>
        </div>

    </div>
    <!-- /. ROW  -->



    <div class="row">
        <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
                <div class="panel-body easypiechart-panel">
                    <h4>Customers</h4>
                    <div class="easypiechart" id="easypiechart-blue" data-percent="82" ><span class="percent">82%</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
                <div class="panel-body easypiechart-panel">
                    <h4>Sales</h4>
                    <div class="easypiechart" id="easypiechart-orange" data-percent="55" ><span class="percent">55%</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
                <div class="panel-body easypiechart-panel">
                    <h4>Profits</h4>
                    <div class="easypiechart" id="easypiechart-teal" data-percent="84" ><span class="percent">84%</span>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-xs-6 col-md-3">
            <div class="panel panel-default">
                <div class="panel-body easypiechart-panel">
                    <h4>No. of Visits</h4>
                    <div class="easypiechart" id="easypiechart-red" data-percent="46" ><span class="percent">46%</span>
                    </div>
                </div>
            </div>
        </div>
    </div><!--/.row-->





    <div class="row">
        <div class="col-md-4 col-sm-12 col-xs-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Tasks Panel
                </div>
                <div class="panel-body">
                    <div class="list-group">

                        <a href="#" class="list-group-item">
                            <span class="badge">7 minutes ago</span>
                            <i class="fa fa-fw fa-comment"></i> Commented on a post
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="badge">16 minutes ago</span>
                            <i class="fa fa-fw fa-truck"></i> Order 392 shipped
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="badge">36 minutes ago</span>
                            <i class="fa fa-fw fa-globe"></i> Invoice 653 has paid
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="badge">1 hour ago</span>
                            <i class="fa fa-fw fa-user"></i> A new user has been added
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="badge">1.23 hour ago</span>
                            <i class="fa fa-fw fa-user"></i> A new user has added
                        </a>
                        <a href="#" class="list-group-item">
                            <span class="badge">yesterday</span>
                            <i class="fa fa-fw fa-globe"></i> Saved the world
                        </a>
                    </div>
                    <div class="text-right">
                        <a href="#">More Tasks <i class="fa fa-arrow-circle-right"></i></a>
                    </div>
                </div>
            </div>

        </div>
        <div class="col-md-8 col-sm-12 col-xs-12">

            <div class="panel panel-default">
                <div class="panel-heading">
                    Responsive Table Example
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>S No.</th>
                                <th>First Name</th>
                                <th>Last Name</th>
                                <th>User Name</th>
                                <th>Email ID.</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>John</td>
                                <td>Doe</td>
                                <td>John15482</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>Kimsila</td>
                                <td>Marriye</td>
                                <td>Kim1425</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>Rossye</td>
                                <td>Nermal</td>
                                <td>Rossy1245</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>Richard</td>
                                <td>Orieal</td>
                                <td>Rich5685</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>Jacob</td>
                                <td>Hielsar</td>
                                <td>Jac4587</td>
                                <td>name@site.com</td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>Wrapel</td>
                                <td>Dere</td>
                                <td>Wrap4585</td>
                                <td>name@site.com</td>
                            </tr>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>
    </div>


        <table class="responsive-table striped">
            <thead>
            <tr>
                <th data-field="name">Name</th>
                <th data-field="description">Description</th>
                <th data-field="jenkins">Jenkins</th>
                <th data-field="sonar">Sonar</th>
            </tr>
            </thead>
            <#list projects as project>
                <tr>
                    <td>
                        <a href="/project/show/${project.id}" class="waves-effect waves-teal">${project.name}</a>
                    </td>
                    <td>
                        ${project.description}
                    </td>
                    <td>
                        <#if project.getJenkinsUrl()?has_content>
                            <a href="${project.getJenkinsUrl()}"><img class="serviceLogo" src="<@c.url value="/resources/img/jenkins.png"/>"/></a>
                        </#if>
                    </td>
                    <td>
                        <#if project.getSonarUrl()?has_content>
                            <a href="${project.getSonarUrl()}"><img class="serviceLogo" src="<@c.url value="/resources/img/sonar.png"/>"/></a>
                        </#if>
                    </td>
                </tr>
            </#list>
        </table>
    </@layout.put>
</@layout.extends>

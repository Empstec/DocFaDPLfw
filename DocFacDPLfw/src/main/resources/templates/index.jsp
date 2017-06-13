<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content="Salvador Puertes Aleixandre"/>
    
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    
    <!--Core CSS -->
    <link href="/VariabilidadProcesos/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/VariabilidadProcesos/resources/css/bootstrap-reset.css" rel="stylesheet"/>
    <link href="/VariabilidadProcesos/resources/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="/VariabilidadProcesos/resources/css/style.css" rel="stylesheet" />
    <link href="/VariabilidadProcesos/resources/css/treeview.css" rel="stylesheet" />
    
    <!-- Custom styles for template -->
    <link href="/VariabilidadProcesos/resources/css/style.css" rel="stylesheet"/>
    <link href="/VariabilidadProcesos/resources/css/style-responsive.css" rel="stylesheet" />

</head>

<body>

<section id="container" >
<!--header start-->
<header class="header fixed-top clearfix">
<!--<div class="nav notify-row" id="top_menu">

</div>
<div class="top-nav clearfix">-->
    <!--search start-->
    <ul class="nav pull-left top-menu">
        <li>
            <input type="text" class="form-control search" placeholder=" Search"/>
            <button class="btn btn-info pull-right">Buscar</button>
        </li>
        <li>
            <div style="margin-left: 30px">
                <button class="btn btn-info">Ver</nutton><button style="margin-left: 15px" class="btn btn-info">Crear</button>
            </div>
        </li>
    </ul>
    <!--search end-->
</div>
</header>
<!--header end-->
<aside>
    <div id="sidebar" class="nav-collapse">
        <!-- sidebar menu start-->
        <div class="pull-right hide-btn"><div class="fa fa-chevron-left my-ico"></div></div>
        <div class="leftside-navigation">
            <div class="css-treeview">
    <ul>
        <li><input type="checkbox" id="item-0" /><label for="item-0">This Folder is Closed By Default</label>
            <ul>
                <li><input type="checkbox" id="item-0-0" /><label for="item-0-0">Ooops! A Nested Folder</label>
                    <ul>
                        <li><input type="checkbox" id="item-0-0-0" /><label for="item-0-0-0">Look Ma - No Hands!</label>
                            <ul>
                                <li><a href="./">First Nested Item</a></li>
                                <li><a href="./">Second Nested Item</a></li>
                                <li><a href="./">Third Nested Item</a></li>
                                <li><a href="./">Fourth Nested Item</a></li>
                            </ul>
                        </li>
                        <li><a href="./">Item 1</a></li>
                        <li><a href="./">Item 2</a></li>
                        <li><a href="./">Item 3</a></li>
                    </ul>
                </li>
                <li><input type="checkbox" id="item-0-1" /><label for="item-0-1">Yet Another One</label>
                    <ul>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                    </ul>
                </li>
                <li><input type="checkbox" id="item-0-2" disabled="disabled" /><label for="item-0-2">Disabled Nested Items</label>
                    <ul>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                    </ul>
                </li>
                <li><a href="./">item</a></li>
                <li><a href="./">item</a></li>
                <li><a href="./">item</a></li>
                <li><a href="./">item</a></li>
        </ul>
</li>
<li><input type="checkbox" id="item-1" checked="checked" /><label for="item-1">This One is Open by Default...</label>
        <ul>
            <li><input type="checkbox" id="item-1-0" /><label for="item-1-0">And Contains More Nested Items...</label>
                <ul>
                    <li><a href="./">Look Ma - No Hands</a></li>
                    <li><a href="./">Another Item</a></li>
                    <li><a href="./">And Yet Another</a></li>
                </ul>
            </li>
            <li><a href="./">Lorem</a></li>
            <li><a href="./">Ipsum</a></li>
            <li><a href="./">Dolor</a></li>
            <li><a href="./">Sit Amet</a></li>
        </ul>
</li>
<li><input type="checkbox" id="item-2" /><label for="item-2">Can You Believe...</label>
        <ul>
                <li><input type="checkbox" id="item-2-0" /><label for="item-2-0">That This Treeview...</label>
                    <ul>
                        <li><input type="checkbox" id="item-2-2-0" /><label for="item-2-2-0">Does Not Use Any JavaScript...</label>
                            <ul>
                                <li><a href="./">But Relies Only</a></li>
                                <li><a href="./">On the Power</a></li>
                                <li><a href="./">Of CSS3</a></li>
                            </ul>
                        </li>
                        <li><a href="./">Item 1</a></li>
                        <li><a href="./">Item 2</a></li>
                        <li><a href="./">Item 3</a></li>
                    </ul>
                </li>
                <li><input type="checkbox" id="item-2-1" /><label for="item-2-1">This is a Folder With...</label>
                    <ul>
                        <li><a href="./">Some Nested Items...</a></li>
                        <li><a href="./">Some Nested Items...</a></li>
                        <li><a href="./">Some Nested Items...</a></li>
                        <li><a href="./">Some Nested Items...</a></li>
                        <li><a href="./">Some Nested Items...</a></li>
                    </ul>
                </li>
                <li><input type="checkbox" id="item-2-2" disabled="disabled" /><label for="item-2-2">Disabled Nested Items</label>
                    <ul>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                        <li><a href="./">item</a></li>
                    </ul>
                </li>
            </ul>
        </li>
    </ul>
</div>
        </div>
                
<!-- sidebar menu end-->
    </div>
</aside>
<!--sidebar end-->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
        <!-- page start-->
        <div class="row">
            <div class="col-sm-12">
                <section class="panel">
                    <header class="panel-heading">
                        Creados de contenido
                    </header>
                    <div class="panel-body">
                        <div id="docContent">
                            <div>
                                <span>Título:<input type="text" class="infDoc" id="titleDoc"/></span>
                            </div>
                            <div>
                                <span>Descripción:<input type="text" class="infDoc" id="descDoc"/></span>
                            </div>
                            <div>
                                <button id="saveDoc" class="btn btn-success">Guardar</nutton>
                            </div>
                        </div>
                        <div class="tableContent">
                            <table id="tableContent">
                                <thead>
                                    <tr>
                                        <td>
                                            Tipo
                                        </td>
                                        <td>
                                            Contenido
                                        </td>
                                        <td>
                                            <div id="add" class="fa fa-plus"></div>
                                        </td>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>
                                            <select class="selectType" data-numberType="1">
                                                <option value="title">Título</option>
                                                <option value="subtitle">Subtítulo</option>
                                                <option value="paragraph">Texto</option>
                                            </select>
                                        </td>
                                        <td colspan=2>
                                            <input type="text" class="contentDITA" data-numberContent="1"/>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <button class="btn btn-success" id="saveAll">Guardar</button>
                        </div>
                    </div>
                </section>
            </div>
        </div>
        <!-- page end-->
        </section>
    </section>
    <!--main content end-->
</section>

<!--Core js-->
<script src="/VariabilidadProcesos/resources/js/jquery-3.1.1.js"></script>
<script src="/VariabilidadProcesos/resources/js/bootstrap.min.js"></script>

<script class="include" type="text/javascript" src="/VariabilidadProcesos/resources/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="/VariabilidadProcesos/resources/js/jquery.scrollTo.min.js"></script>
<script src="/VariabilidadProcesos/resources/js/jQuery-slimScroll-1.3.0/jquery.slimscroll.js"></script>
<script src="/VariabilidadProcesos/resources/js/jquery.nicescroll.js"></script>

<script src="/VariabilidadProcesos/resources/js/base.js"></script>
<script src="/VariabilidadProcesos/resources/js/functions.js"></script>

</body>
</html>

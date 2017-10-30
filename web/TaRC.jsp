<%@page import="model.Servicio"%>
<%@page import="model.EmpresaCliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Agregar Trabajo a Realizar</title>
        <!--
        Ocean Theme
        http://www.templatemo.com/tm-484-ocean
        -->

        <!-- load stylesheets -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->
        <link rel="stylesheet" href="css/proyecto.css"> 
        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>

    <body>

        <div class="row tm-section">

            <section class="tm-section-contact">

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-xs-center">

                    <h2 class="tm-section-title">Agregar Trabajo a Realizar</h2>
                    <br><br>

                </div>
                <div class="form-group col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 tm-form-group-left">
                    <form align="center" action="TrabajoARealizarC" method="POST" class="tm-contact-form"> 
                        <label align="center" for="idE">Empresa</label>
                        <select name="idE" class="form-control form-control-lg">
                            <%
                                if (request.getAttribute("empresas") != null) {
                                    ArrayList<EmpresaCliente> array = (ArrayList<EmpresaCliente>) request.getAttribute("empresas");
                                    for (EmpresaCliente e : array) {
                            %>
                            <option value="<%=e.getNIT()%>"><%=e.getNombreEmpresa()%></option>
                            <%      }
                                }
                            %>
                        </select>  
                        <br>
                        <label align="center" for="idS">Servicio</label>
                        <select name="idS" class="form-control form-control-lg">
                            <%
                                if (request.getAttribute("servicios") != null) {
                                    ArrayList<Servicio> array = (ArrayList<Servicio>) request.getAttribute("servicios");
                                    for (Servicio s : array) {
                            %>
                            <option value="<%=s.getIdServicio()%>"><%=s.getNombreS()%></option>
                            <%      }
                                }
                            %>
                        </select>  
                        <br>
                        <label align="center" for="urgencia">Urgencia</label>
                        <select name="urgencia" class="form-control form-control-lg">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                        <br>
                        <label align="center" for="detalles">Detalles</label>
                        <input type="text" name="detalles" maxlength="50" class="form-control" placeholder="máx. 50"  required/>
                        <br>
                        <br>
                        <button type="submit" class="btn tm-bordered-btn pull-xs-center">Agregar</button>
                        <a class="btn tm-bordered-btn pull-xs-center" href="menu.html" role="button">Volver</a>
                    </form>  

                </div>                         


            </section>



        </div>

    </div>

</body>
</html>
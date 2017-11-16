<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title> Add Item</title>

        <style> 

            /*  Style inputs with type="text", select elements and textareas */
            .input[type=text], select, textarea {
                height: 250px;
                width: 300px; /* Full width */
                padding: 12px; /* Some padding */  
                border: 1px solid #ccc; /* Gray border */
                border-radius: 4px; /* Rounded borders */
                box-sizing: border-box; /* Make sure that padding and width stays in place */
                margin-top: 6px; /* Add a top margin */
                margin-bottom: 16px; /* Bottom margin */
                resize: vertical /* Allow the user to vertically resize the textarea (not horizontally) */
            }
            textarea {
                outline: none;
                height: 250px;
                /*resize: none;*/
                overflow: auto;
            }
            input:focus {
                outline: none; /* Скрываем рамку */
            }
            /* Style the submit button with a specific background color etc */
            input[type=submit] {
                /*background-color: #4CAF50;*/
                background-color: #039be5;
                color: white;
                padding: 12px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            /* When moving the mouse over the submit button, add a darker green color */
            input[type=submit]:hover {
                background-color: #ff9800;
            }

            /* Add a background color and some padding around the form */
            .Mycontainer {
                /*width: 400px;*/
                border-radius: 5px;
                border: 1px solid #ccc;
                background-color: #f2f2f2;
                padding: 20px;
                margin: auto;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 35%;
            }
            .error{
                color: red;
                font-size: 10px;
            }


        </style>


        <%--meta link--%>
        <%@ include file="common/meta.jsp" %>
        <!--Import jQuery before materialize.js-->
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
        <script type="text/javascript" src="<c:url value="/resources/item-board_resources/js/materialize.js"/>"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>
        <%--header link--%>
        <%@ include file="common/header.jsp" %>
    </head>

    <body>

        <c:forEach var="map" items="${map}">

            <c:set var="numErr" value="${map.value}"/>


            <c:choose>

                <c:when test="${numErr ==0}">
                    <c:set var="nameErr" value="${map.key}"/>
                </c:when>

                <c:when test = "${numErr ==1}">
                    <c:set var="pickErr" value="${map.key}"/>
                </c:when>
                <c:when test = "${numErr ==2}">
                    <c:set var="pricekErr" value="${map.key}"/>
                </c:when>
                <c:when test = "${numErr ==3}">
                    <c:set var="aboutErr" value="${map.key}"/>
                </c:when>

            </c:choose>

        </c:forEach>
        <br>
        <br>
        <br>
        

        <div class="Mycontainer">
            <form action="create.html">

                <label >Name</label>
                <input type="text" id="name" name="name" placeholder="Your item name.." required>
                <div class="error fullwidth"><c:out value="${nameErr}"/></div>
                <br>

                <label >Picture</label>
                <input type="text" id="pic" name="pic" placeholder="Please enter link of picture.." required>
                <div class="error fullwidth"><c:out value="${pickErr}"/></div>
                <hr>

                <label for="cat">Category</label>
                <select id="cat" name="cat">
                    <option value="a">Car</option>
                    <option value="h">Weapon</option>
                    <option value="E">Real Estate</option>
                </select>

                <hr>
                <label for="price">Price</label>
                <input type="text" id="price" name="price" placeholder="Please enter your price.." required>
                <div class="error fullwidth"><c:out value="${pricekErr}"/></div>

                <br>
                <label for="about">About</label>
                <textarea name="about" placeholder="Please enter about.." required></textarea>
                <div class="error fullwidth"><c:out value="${aboutErr}"/></div>

                <br>
                <input  type="submit" value="Create"/>
            </form>
        </div>


    </body>
    <%--footer link--%>
    <%@ include file="common/footer.jsp" %>

</html>
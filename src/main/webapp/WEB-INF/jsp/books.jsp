<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books!</title>
        <script language="javascript">
            
            var numberOfAuthors = 1;
            var numberOfPublishers = 1;
            
            function addAuthor()
            {
                var selectElement = document.createElement("select");
                selectElement.setAttribute("name", "authors["+numberOfAuthors+"]");
                
                <c:forEach var="author" items="${authors}">
                    var optionElement = document.createElement("option");
                    optionElement.setAttribute("value", "${author.id}");
                    optionElement.innerHTML="${author.name}";
                    selectElement.appendChild(optionElement);
                </c:forEach>
                
                document.getElementById("additionalAuthors").appendChild(selectElement);
                
                var breakLine = document.createElement("br");
                document.getElementById("additionalAuthors").appendChild(breakLine);
                
                numberOfAuthors++;
            }
            
            function addPublisher()
            {
                var selectElement = document.createElement("select");
                
                
                <c:forEach var="publisher" items="${publishers}">
                    var optionElement = document.createElement("option");
                    optionElement.setAttribute("value", "${publisher.id}");
                    optionElement.innerHTML="${publisher.name}";
                    selectElement.appendChild(optionElement);
                </c:forEach>
                
                document.getElementById("additionalPublishers").appendChild(selectElement);
                
                var breakLine = document.createElement("br");
                document.getElementById("additionalPublishers").appendChild(breakLine);
            }
        </script>
    </head>
    <body>
        <h1>Books!</h1>

        <p>Good luck!</p>
        
        
        
        <c:if test="${not empty books}">
            <h2>All books</h2>
            <c:forEach var="book" items="${books}">
                <a href="${pageContext.request.contextPath}/app/books/${book.id}">${book.name}</a><br/>
            </c:forEach>
        </c:if>
                
        <p>Search by book name</p>
        <form action="${pageContext.request.contextPath}/app/booksByName" method="GET">
            <input type="text" name=""/>
        </form>
            
        <div>  
            <p>Search by author</p>
            <form action="${pageContext.request.contextPath}/app/booksByAuthor" method="GET">
                <input type="text" name=""/>
            </form>
        </div>
                
        <div>
            <p>Add a book!</p>
            <form:form action="${pageContext.request.contextPath}/app/books" method="POST">
                ISBN:<input type="text" name="ISBN"/><br/>
                Name:<input type="text" name="name"/><br/>
                
                Authors:<br/>
                <select name="authors[0]" id="authors[0]">
                    <c:forEach var="author" items="${authors}">
                        <option value="${author.id}">${author.name}</option>
                    </c:forEach>
                </select>
                <input type="button" onclick="addAuthor()" name="addAuthorButton" value="Add another author"/>
                <div id="additionalAuthors"></div>
                <br/>
                
                
                
                Publishers:<br/>
                <select name="publishers[0]">
                    <c:forEach var="publisher" items="${publishers}">
                        <option value="${publisher.id}">${publisher.name}</option>
                    </c:forEach>
                </select>
                <input type="button" onclick="addPublisher()" name="addPublisherButton" value="Add publisher"/>
                <div id="additionalPublishers"></div>
                <br/>
                
                Publishing year:<input type="text" id="publishingYear" name="publishingYear"/><br/>
                <input type="submit" value="Add"/>
            </form:form>
                
            <form:form action="${pageContext.request.contextPath}/app/authors" method="POST">
                <input type="text" name="name"/>
                <input type="submit" value="New author"/>
            </form:form>
                
            <form:form action="${pageContext.request.contextPath}/app/publishers" method="POST">
                <input type="text" name="name"/>
                <input type="submit" value="New publisher"/>
            </form:form>
        </div>
                
    </body>
</html>

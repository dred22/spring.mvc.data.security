    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/public/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/public/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/public/js/script.js"></script>
    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>
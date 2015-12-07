<html>
  <head>
    <title></title>
  </head>
  <body>
    hello world
    <script type="text/javascript" src="content/bower_components/jquery/dist/jquery.min.js"></script>
    <script>
      $(document).ready(function() {
        $.ajax({
          async:false,
          url: "/jsonp",
          type: "GET",
          dataType: 'jsonp',
          jsonp: 'callback',
          data: "",
          timeout: 5000,
          success: function (json) {
            console.log(json.aaa);
          }
        });
      });
    </script>
  </body>
</html>

/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.35
 * Generated at: 2020-07-13 07:47:06 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.register;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class step2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("  <head>\r\n");
      out.write("    <meta charset=\"UTF-8\" />\r\n");
      out.write("    <title>Insert title here</title>\r\n");
      out.write("    <!-- resources 앞에 / 를 붙일때는 context path가 없는 경우일 때 -->\r\n");
      out.write("    <link\r\n");
      out.write("      rel=\"stylesheet\"\r\n");
      out.write("      href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"\r\n");
      out.write("      integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\"\r\n");
      out.write("      crossorigin=\"anonymous\"\r\n");
      out.write("    />\r\n");
      out.write("    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.js\"></script>\r\n");
      out.write("    <!-- \r\n");
      out.write("    validation 사용자 작성 코드 삽입 => 아래의 순서 유의\r\n");
      out.write("    \t1. Jquery 라이브러리\r\n");
      out.write("    \t2. Jquery-Validate 라이브러리\r\n");
      out.write("    \t3. js 파일    \t\r\n");
      out.write("    -->    \r\n");
      out.write("    <script src=\"/resources/js/join.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("    $(function(){\r\n");
      out.write("    \tlet gender='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${register.gender}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("    \tconsole.log(gender);\r\n");
      out.write("    \tif(gender === '남'){\r\n");
      out.write("    \t\t$(\"input:radio[name='gender'][value='남']\").prop(\"checked\", true);\r\n");
      out.write("    \t}else if(gender === '여'){\r\n");
      out.write("    \t\t$(\"input:radio[name='gender'][value='여']\").prop(\"checked\", true);    \t\t\r\n");
      out.write("    \t}    \t\r\n");
      out.write("    })\r\n");
      out.write("    </script>\r\n");
      out.write("  </head>\r\n");
      out.write("  <body style=\"background-color:#F5F5F5;\">\r\n");
      out.write("    <div class=\"container\" style=\"margin-top:40px\">\r\n");
      out.write("      <form id=\"joinform\" method=\"post\" action=\"/register/step3\">\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"userid\" class=\"col-sm-2 col-form-label\">아이디</label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              name=\"userid\"\r\n");
      out.write("              id=\"userid\"\r\n");
      out.write("              class=\"form-control\"\r\n");
      out.write("              placeholder=\"아이디를 입력하세요\"\r\n");
      out.write("              value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${register.userid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"              \r\n");
      out.write("            />\r\n");
      out.write("            <small id=\"userid\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"pass1\" class=\"col-sm-2 col-form-label\">비밀번호</label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"password\"\r\n");
      out.write("              name=\"password\"\r\n");
      out.write("              id=\"password\"\r\n");
      out.write("              class=\"form-control\"\r\n");
      out.write("              placeholder=\"비밀번호를 입력하세요\"          \r\n");
      out.write("            />\r\n");
      out.write("            <small id=\"password\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"pass2\" class=\"col-sm-2 col-form-label\"\r\n");
      out.write("            >비밀번호 확인\r\n");
      out.write("          </label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"password\"\r\n");
      out.write("              name=\"confirm_password\"\r\n");
      out.write("              id=\"confirm_password\"\r\n");
      out.write("              class=\"form-control\"\r\n");
      out.write("              placeholder=\"비밀번호를 다시 입력하세요\" \r\n");
      out.write("            />\r\n");
      out.write("            <small id=\"confirm_password\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"name\" class=\"col-sm-2 col-form-label\">이름 </label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"text\"\r\n");
      out.write("              name=\"name\"\r\n");
      out.write("              id=\"name\"\r\n");
      out.write("              class=\"form-control\"\r\n");
      out.write("              placeholder=\"이름을 입력하세요\"\r\n");
      out.write("              value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${register.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("            />\r\n");
      out.write("            <small id=\"name\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"pass2\" class=\"col-sm-2 col-form-label\">성별 </label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <div class=\"form-check form-check-inline\">\r\n");
      out.write("              <input\r\n");
      out.write("                type=\"radio\"\r\n");
      out.write("                id=\"gender\"\r\n");
      out.write("                name=\"gender\"\r\n");
      out.write("                value=\"남\" \r\n");
      out.write("                class=\"form-check-input\"\r\n");
      out.write("              />남\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"form-check form-check-inline\">\r\n");
      out.write("              <input\r\n");
      out.write("                type=\"radio\"\r\n");
      out.write("                name=\"gender\"\r\n");
      out.write("                value=\"여\"\r\n");
      out.write("                class=\"form-check-input\"\r\n");
      out.write("              />여\r\n");
      out.write("            </div>\r\n");
      out.write("            <small id=\"gender\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group row justify-content-center\">\r\n");
      out.write("          <label for=\"email\" class=\"col-sm-2 col-form-label\">이메일</label>\r\n");
      out.write("          <div class=\"col-sm-6\">\r\n");
      out.write("            <input\r\n");
      out.write("              type=\"email\"\r\n");
      out.write("              name=\"email\"\r\n");
      out.write("              id=\"email\"\r\n");
      out.write("              class=\"form-control\"\r\n");
      out.write("              placeholder=\"example@gmail.com\"\r\n");
      out.write("              value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${register.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("            />\r\n");
      out.write("            <small id=\"email\" class=\"text-info\"></small>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"form-group text-center\">\r\n");
      out.write("          <button type=\"submit\" class=\"btn btn-primary\">입력</button>\r\n");
      out.write("          <button type=\"reset\" class=\"btn btn-secondary\">취소</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </form>\r\n");
      out.write("    </div>\r\n");
      out.write("<script>\r\n");
      out.write("$(function(){\r\n");
      out.write("\t/* $(\".btn-primary \").click(function(){\r\n");
      out.write("\t\t//폼안의 데이터를 json 형태로 서버로 보내기\r\n");
      out.write("\t\t//입력 후 결과를 받아 출력하기\r\n");
      out.write("\t\tlet regist={\r\n");
      out.write("\t\t\tuserid:$(\"#userid\").val(),\r\n");
      out.write("\t\t\tpassword:$(\"#password\").val(),\r\n");
      out.write("\t\t\tconfirm_password:$(\"#confirm_password\").val(),\r\n");
      out.write("\t\t\tname:$(\"#name\").val(),\r\n");
      out.write("\t\t\tgender:$(\"input[type=radio]:checked\").val(),\r\n");
      out.write("\t\t\temail:$(\"#email\").val()\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:'/register/insert',\r\n");
      out.write("\t\t\ttype:'post',\r\n");
      out.write("\t\t\tdata:JSON.stringify(regist),\r\n");
      out.write("\t\t\tcontentType:\"application/json\",\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\talert(data); \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tid:$(\"#id\").val(\"\");\r\n");
      out.write("\t\t\t\tpassword:$(\"#password\").val(\"\");\r\n");
      out.write("\t\t\t\tconfirm_password:$(\"#confirm_password\").val(\"\");\r\n");
      out.write("\t\t\t\tname:$(\"#name\").val(\"\");\r\n");
      out.write("\t\t\t\tgender:$(\"#gender\").val(\"\");\r\n");
      out.write("\t\t\t\temail:$(\"#email\").val(\"\");\r\n");
      out.write("\t\t\t\tid:$(\"#id\").focus();\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(xhr, txtStatus, error){\r\n");
      out.write("\t\t\t\talert(xhr.responseText);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t}) */\r\n");
      out.write("\t$(\".btn-primary \").click(function(){\r\n");
      out.write("\t\t//폼안의 데이터를 json 형태로 서버로 보내기\r\n");
      out.write("\t\t//입력 후 결과를 받아 출력하기\r\n");
      out.write("\t\tlet regist={\r\n");
      out.write("\t\t\tuserid:$(\"#userid\").val(),\r\n");
      out.write("\t\t\tpassword:$(\"#password\").val(),\r\n");
      out.write("\t\t\tconfirm_password:$(\"#confirm_password\").val(),\r\n");
      out.write("\t\t\tname:$(\"#name\").val(),\r\n");
      out.write("\t\t\tgender:$(\"input[type=radio]:checked\").val(),\r\n");
      out.write("\t\t\temail:$(\"#email\").val()\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\turl:'/register/insert',\r\n");
      out.write("\t\t\ttype:'post',\r\n");
      out.write("\t\t\tdata:$(\"form\").serialize(),\r\n");
      out.write("\t\t\tsuccess:function(data){\r\n");
      out.write("\t\t\t\talert(data); \r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\tid:$(\"#id\").val(\"\");\r\n");
      out.write("\t\t\t\tpassword:$(\"#password\").val(\"\");\r\n");
      out.write("\t\t\t\tconfirm_password:$(\"#confirm_password\").val(\"\");\r\n");
      out.write("\t\t\t\tname:$(\"#name\").val(\"\");\r\n");
      out.write("\t\t\t\tgender:$(\"#gender\").val(\"\");\r\n");
      out.write("\t\t\t\temail:$(\"#email\").val(\"\");\r\n");
      out.write("\t\t\t\tid:$(\"#id\").focus();\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror:function(xhr, txtStatus, error){\r\n");
      out.write("\t\t\t\talert(xhr.responseText);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t})\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("</script>\r\n");
      out.write("  </body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

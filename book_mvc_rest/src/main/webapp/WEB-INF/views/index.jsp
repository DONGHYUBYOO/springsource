<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>도서 관리 시스템</title>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
      integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
      crossorigin="anonymous"
    />
    <script
      src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
      integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
      integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
      crossorigin="anonymous"
    ></script>
    <script>    
    	let msg='${error}';    	
		if(msg !== '') {
			alert(msg);
		}
    </script>
    <script>
      $(function () {
        //페이지 로드시 첫 메뉴에 해당하는 것 보여주기
        let tab='${tab}';
        if(tab === '') {
        	tab='insert';
        }
        $('#myList a[href="#'+tab+'"]').tab("show");
      });
    </script>
  </head>
  <body>
    <div class="jumbotron">
      <h3>SpringMVC로 구현한 도서관리시스템</h3>
    </div>
    <!-- href의 값과 id 값 일치시켜야 움직임 -->
    <div class="container-fluid">
      <div class="row">
        <div class="col-xl-3">
          <div class="list-group" id="myList" role="tablist">
            <a
              class="list-group-item list-group-item-action"
              data-toggle="list"
              href="#insert"
              role="tab"
              >도서 정보 입력</a
            >
            <a
              class="list-group-item list-group-item-action"
              data-toggle="list"
              href="#all"
              role="tab"
              >도서 목록 보기</a
            >
            <a
              class="list-group-item list-group-item-action"
              data-toggle="list"
              href="#delete"
              role="tab"
              >도서 정보 삭제</a
            >
            <a
              class="list-group-item list-group-item-action"
              data-toggle="list"
              href="#search"
              role="tab"
              >도서 정보 검색</a
            >
            <a
              class="list-group-item list-group-item-action"
              data-toggle="list"
              href="#modify"
              role="tab"
              >도서 정보 수정</a
            >
          </div>
        </div>
        <div class="col-xl-9">
          <div class="tab-content" id="nav-tabContent">
            <!-- all이 호출되는 경우에는 페이지 전환 book_select_result.jsp로 -->
            <div class="tab-pane fade" id="delete" role="tabpanel">
              <jsp:include page="book_delete.jsp" flush="false" />
            </div>
            <div class="tab-pane fade" id="search" role="tabpanel">
              <jsp:include page="book_search.jsp" flush="false" />
            </div>
            <div class="tab-pane fade" id="modify" role="tabpanel">
              <jsp:include page="book_modify.jsp" flush="false" />
            </div>
            <div class="tab-pane fade active" id="insert" role="tabpanel">
              <jsp:include page="book_insert.jsp" flush="false" />
            </div>
          </div>
        </div>
      </div>
    </div>
    <script>
    //도서 목록 보기 버튼 클릭시
      $('#myList a[href="#all"]').click(function (e) {
        location.href = "listBook";
      });
    </script>	
  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp" %>

	<%
		/*
		form tag
			>> 아래에 있는 3개의 button[type="submit"]과 연결해서 POST방식으로 요청을 보내는데 사용한다.
			>> 수정이나 삭제를 하는데 반드시 게시물 번호인 bno가 필요하기 때문에 input[type="hidden"]으로 bno를 넘긴다.
		*/
	%>
	<form role="form" action="modifyPage" method="post">
		<input type="hidden" name="bno" value="${boardVO.bno}">
		<input type="hidden" name="page" value="${cri.page}">
		<input type="hidden" name="perPageNum" value="${cri.perPageNum}">
		<input type="hidden" name="searchType" value="${cri.searchType}">
		<input type="hidden" name="keyword" value="${cri.keyword}">
	</form>

	<div class="box-body">
		<div class="form-group">
			<label for="exampleInputEmail1">Title</label>
			<input type="text" name="title" class="form-control" value="${boardVO.title}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Content</label>
			<textarea rows="3" class="form-control" name="content" readonly="readonly">${boardVO.content}</textarea>
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Writer</label>
			<input type="text" name="writer" class="form-control" value="${boardVO.writer}" readonly="readonly">
		</div>
	</div> <!-- /.box-body -->
	
	<div class="box-footer">
		<button type="submit" class="btn btn-warning modifyBtn">MODIFY</button>
		<button type="submit" class="btn btn-danger removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary goListBtn">RETURN TO LIST</button>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				<div class="box-body">
					<label for="newReplyWriter">Writer</label>
					<input class="form-control" type="text" placeholder="USER ID" id="newReplyWriter">
					<label for="newReplyText">ReplyText</label>
					<input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">
				</div> <!-- /.box-body -->
				<div class="box-footer">
					<button type="submit" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- The time line -->
	<ul class="timeline">
		<!-- time line time label -->
		<li class="time-label" id="repliesDiv"><span class="bg-green">Replies List</span></li>
	</ul>
	
	<div class="text-center">
		<ul id="pagination" class="pagination pagination-sm no-margin"></ul>
	</div>
	
	<!-- Modal to modify/delete the replies -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal contents -->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title"></h4>
				</div>
				<div class="modal-body" data-rno>
					<p><input type="text" id="replytext" class="form-control"></p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">Modify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

<%@ include file="../include/footer.jsp" %>

<script id="template" type="text/x-handlebars-template">
	{{#each .}}
		<li class="replyLi" data-rno={{rno}}>
		<i class="fa fa-comments bg-blue"></i>
			<div class="timeline-item">
				<span class="time">
					<i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
				</span>
				<h3 class="timeline-header"><strong>{{rno}}</strong> - {{replyer}}</h3>
				<div class="timeline-body">{{replytext}}</div>
				<div class="timeline-footer">
					<a class="btn btn-primary btn-xs" data-toggle="modal" data-target="#modifyModal">Modify</a>
				</div>
			</div>
		</li>
	{{/each}}
</script>

<script>
	$(document).ready(function() {
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$(".modifyBtn").on("click", function() {
			formObj.attr("action", "/sboard/modifyPage");
			formObj.attr("method", "get");
			formObj.submit();
		});
		
		$(".removeBtn").on("click", function() {
			formObj.attr("action", "/sboard/removePage");
			formObj.submit();
		});
		
		$(".goListBtn").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/sboard/list");
			formObj.submit();
		});
	});
	
	/* Handlebars는 "helper"라는 기능을 이용해서 데이터의 상세한 처리에 필요한 기능을 처리한다. */
	/* "registerHelper" -> 사용자 지정 기능을 새롭게 정의한다. */
	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	
	var bno = ${boardVO.bno};
	var replyPage = 1;
	
	function getPage(pageInfo) {
		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#repliesDiv"), $("#template"));
			printPaging(data.pageMaker, $(".pagination"));
			
			$("#modifyModal").modal('hide');
		});
	}
	
	var printData = function(replyArr, target, templateObject) {
		var template = Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$('.replyLi').remove();
		target.after(html);
	};
	
	var printPaging = function(pageMaker, target) {
		var str = "";
		
		if(pageMaker.prev) {
			str += "<li><a href='" + (pageMaker.startPage - 1) + "'> << </a></li>";
		}
		
		for(var i = pageMaker.startPage, len = pageMaker.endPage; i <= len; i++) {
			var strClass = pageMaker.cri.page == i ? 'class=active' : '';
			str += "<li " + strClass + "><a href='" + i + "'>" + i + "</a></li>";
		}
		
		if(pageMaker.next) {
			str += "<li><a href='" + (pageMaker.endPage + 1) + "'> >> </a></li>";
		}
		target.html(str);
	};
	
	$("#repliesDiv").on('click', function() {
		if($('.timeline li').size() > 1) { return; }
		getPage("/replies/" + bno + "/1")
	});
	
	$(".pagination").on('click', 'li a', function(event) {
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("/replies/" + bno + "/" + replyPage);
	});
	
	$("#replyAddBtn").on('click', function() {
		var replyerObj = $("#newReplyWriter");
		var replytextObj = $("#newReplyText");
		var replyer = replyerObj.val();
		var replytext = replytextObj.val();
		
		$.ajax({
			type : 'post',
			url : '/replies/',
			headers: {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "POST"
			},
			dataType : 'text',
			data : JSON.stringify({bno:bno, replyer:replyer, replytext:replytext}),
			success : function(result) {
				console.log("result : " + result);
				if(result == 'success') {
					alert("등록 되었습니다.");
					replyPage = 1;
					getPage("/replies/" + bno + "/" + replyPage);
					replyerObj.val("");
					replytextObj.val("");
				}
			}
		});
	});
	
	/* 각 댓글의 버튼 이벤트 처리 */
	$(".timeline").on('click', '.replyLi', function(event) {
		var reply = $(this);
		
		$("#replytext").val(reply.find('.timeline-body').text());
		$(".modal-title").html(reply.attr("data-rno"));
	});
	
	/* 댓글 수정 처리 */
	$("#replyModBtn").on('click', function() {
		var rno = $(".modal-title").html();
		var replytext = $('#replytext').val();
		
		$.ajax({
			type : 'put',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "PUT" 
			},
			data : JSON.stringify({replytext:replytext}),
			dataType : 'text',
			success: function(result) {
				console.log("result : " + result);
				if(result == 'success') {
					alert("수정 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
	
	/* 댓글 삭제 처리 */
	$("#replyDelBtn").on('click', function() {
		var rno = $(".modal-title").html();
		var replytext = $('#replytext').val();
		
		$.ajax({
			type : 'delete',
			url : '/replies/' + rno,
			headers : {
				"Content-Type" : "application/json",
				"X-HTTP-Method-Override" : "DELETE" 
			},
			dataType : 'text',
			success: function(result) {
				console.log("result : " + result);
				if(result == 'success') {
					alert("삭제 되었습니다.");
					getPage("/replies/" + bno + "/" + replyPage);
				}
			}
		});
	});
</script>
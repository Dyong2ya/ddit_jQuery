/**
 * 
 */
currentPage = 1;

//조회수 증가
hitUpdate = function() { 
	$.ajax({
		url : '/board/HitUpdate.do',
		type : 'get',
		data : {"seq" : vidx},
		success : function(res) {
			alert(res.sw);
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}


//댓글삭제
replyDelete = function(t) { //html에서 replyDelete(this)받아오는 거야
	$.ajax({
		url : '/board/ReplyDelete.do',
		type : 'get',
		data : {"renum" : vidx},
		success : function(res) {
			//alert(res.sw); //이거 제대로 실행되나 눈으로 확인하려고 쓰는 거야
			//화면에서 지우기
			$(t).parents('.rep').remove();
		},
		error : function(xhr) {
			alert("상태 : " + xhr.status)
		},
		dataType : 'json'
	})
}

// 댓글 수정 부분
replyModiServer = function(){
   
   $.ajax({
      
      url : '/board/ReplyModify.do',
      type : 'post',
      data : {"renum" : vidx, "cont" : modicont},
      success : function(res){
         
         res.sw
         alert(res.sw);
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      },
      dataType : 'json'
      
   })
   
   
   
   
}



// 댓글 출력 부분
replyListServer = function(t){ // t : 클릭한 제목(요소), 등록버튼일수도
   $.ajax({
      
      url : '/board/ReplyList.do',
      type : 'get',
      data : {"bonum" : vidx},
      success : function(res){
         str = "";
         
         $.each(res, function(i, v){
            
            str+= '<div class="panel-body rep">';
               str+= '<p class="top">';
               str+= '<br>';
               str+= '<span class="name">'+v.name+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
               str+= '<span class="date">'+v.redate+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
               str+= '</p>';
               str+= '<br>';
               str+= '<p class="topbutton">';
               str+= '<input idx="' + v.renum + '" type="button" value="댓글수정" name="re_modify" class="action">';
               str+= '<input idx="' + v.renum + '" type="button" value="댓글삭제" name="re_delete" class="action">';
               str+= '</p>';
               str+= '';
               str+= '<p class="cont"><span class="area">'+v.cont+'</span></p>';
            str+= '</div>';

         
         })
         $(t).parents('.panel').find('.rep').remove();
         $(t).parents('.panel').find('.pbody').append(str);
         
         
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      },
      dataType : 'json'
      
   })
}



// 댓글 저장하는 부분
replyServer = function(t){ // t : 등록 버튼
   
   $.ajax({
      url : '/board/ReplySave.do',
      type : 'post',
      data : board,
      success : function(res){
         //alert("댓글 출력!!!");
         replyListServer(t);
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      },
      dataType : 'json'
   
   })
};

sendServer = function(){
   formdata = $('form').serializeArray();
   console.log(formdata);
   
   $.ajax({
      url : '/board/BoardInsert.do',
      type : 'post',
      data : formdata,
      success : function(res){
         alert(res.sw);
         //listPageServer(1); // 성공하면 리스트페이지를 호출한다. (동기)
      },
      error : function(xhr){
         alert('상태 : ' + xhr.status);
      },
      dataType : 'json'
      
      
      
      
   })
}

listPageServer = function(page){
   $.ajax({
      url : '/board/BoardList.do',
      type : 'post',
      data : {"page": page}, //검은 page는 파라미터로 받은 애고 "page"는 서블릿에서 받아온 애인데 얘로 바꿔주는 거야
      dataType : 'json',
      success : function(res){
         
         str = '<div class="panel-group" id="accordion">';
         
         $.each(res.datas, function(i, v){
            
            str+= '<div class="panel panel-default">';
                str+= '<div class="panel-heading">';
                   str+= '<h4 class="panel-title">';
                   str+= '<a class="action" name="list" idx="' + v.seq + '" data-toggle="collapse" data-parent="#accordion" href="#collapse' +v.seq+ '">';
                   str+= v.title + '</a>';
                   str+= '</h4>';
               str+= '</div>';
                   str+= '<div id="collapse' +v.seq+ '" class="panel-collapse collapse ">';
                  str+= '<div class="panel-body pbody">';
                  str+= '<p class="top">';
                     str+= '작성자 : <span class="name">'+v.name+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '이메일 : <span class="email">'+v.mail+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '작성일 : <span class="date">'+v.date+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '조회수 : <span class="hit">'+v.hit+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                  str+= '</p>';
                  str+= '';
                  str+= '<p class="topbutton">';
                     str+= '<input idx="' + v.seq + '" type="button" value="수정" name="modify" class="action">';
                     str+= '<input idx="' + v.seq + '" type="button" value="삭제" name="delete" class="action">';
                  str+= '</p>';
                  str+= '';
                  str+= '<p class="cont">'+v.cont+'</p>';
                  str+= '<p class="reply">'
                     str+= '<br>';
                  str+= '<br>';
                     str+= '<textarea class="area" row="2" cols="60"></textarea>';
                     str+= '<input idx="' + v.seq + '" type="button" value="등록" name="reply" class="action">';
                     str += '</p>';
                     str+= '<br>';
                     str+= '<br>';
                     str+= '<br>';
                  str+= '</div>';
                str+= '</div>';
             str+= '</div> ';
                                                                                                     
         })
         str+= '</div> ';
         
         
         $('.box').html(str);
         
         
         // 이전 버튼 (startpage > 1)   
         $('#pagelist').empty();
         if(res.spage > 1){
            vpre = '<ul class="pager">';
            vpre += '<li><a class="prev" href="#">이전</a></li>';
            vpre += '</ul>';
            $('#pagelist').append(vpre);
         }

         
         
         
         
         // 페이징 처리
         console.log(res.spage, res.epage, res.tpage);
         vpage = '<ul class="pagination">'
            
            for(i = res.spage; i <=res.epage; i++){
               if(i == currentPage ){
                  vpage += ' <li class = "active"><a class="paging" href="#">' +i + '</a></li>'
               }
               else {
                  vpage += ' <li><a class="paging" href="#">' + i + '</a></li>'
               }
            }
            
         vpage += '</ul>';
         $('#pagelist').append(vpage);

         
         
         // 다음 버튼 (endpage < totalpage)   
         if(res.epage < res.tpage){
            vnext = '<ul class="pager">';
            vnext += '<li ><a class="next" href="#">다음</a></li>';
            vnext += '</ul>';
            $('#pagelist').append(vnext);
         }
         
         
         
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      }
   })
}








listServer = function(){
   
   $.ajax({
      url : '/board/BoardList.do',
      type : 'get',
      dataType : 'json',
      success : function(res){
         
         str = '<div class="panel-group" id="accordion">';
         
         $.each(res, function(i, v){
            
            str+= '<div class="panel panel-default">';
                str+= '<div class="panel-heading">';
                   str+= '<h4 class="panel-title">';
                   str+= '<a data-toggle="collapse" data-parent="#accordion" href="#collapse' +v.seq+ '">';
                   str+= v.title + '</a>';
                   str+= '</h4>';
               str+= '</div>';
                   str+= '<div id="collapse' +v.seq+ '" class="panel-collapse collapse ">';
                  str+= '<div class="panel-body">';
                  str+= '<p class="top">';
                     str+= '작성자 : <span class="name">'+v.name+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '이메일 : <span class="email">'+v.mail+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '작성일 : <span class="date">'+v.date+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                     str+= '조회수 : <span class="hit">'+v.hit+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
                  str+= '</p>';
                  str+= '';
                  str+= '<p class="topbutton">';
                     str+= '<input idx="' + v.seq + '" type="button" value="수정" name="modify" class="action">';
                     str+= '<input idx="' + v.seq + '" type="button" value="삭제" name="delete" class="action">';
                  str+= '</p>';
                  str+= '';
                  str+= '<p class="cont">'+v.cont+'</p>';
                  str+= '<p class="reply">'
                     str+= '<textarea class="area" row="5" cols="60"></textarea>';
                     str+= '<input idx="' + v.seq + '" type="button" value="등록" name="reply" class="action">';
                  str+= '</div>';
                str+= '</div>';
             str+= '</div> ';
                                                                                                     
         })
         str+= '</div> ';
         
         
         $('.box').html(str);
         
      },
      error : function(xhr){
         alert("상태 : " + xhr.status);
      }
   })
}
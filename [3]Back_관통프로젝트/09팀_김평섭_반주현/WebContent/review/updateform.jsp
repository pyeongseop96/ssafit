<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<!-- updateform -->
<html lang="ko">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>리뷰 수정</title>

        <!-- Bootstrap CSS -->
        <link
            rel="stylesheet"
            href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
            crossorigin="anonymous"
        />

        <style>
            body {
                min-height: 100vh;

                background: -webkit-gradient(
                    linear,
                    left bottom,
                    right top,
                    from(#92b5db),
                    to(#1d466c)
                );
                background: -webkit-linear-gradient(
                    bottom left,
                    #92b5db 0%,
                    #1d466c 100%
                );
                background: -moz-linear-gradient(
                    bottom left,
                    #92b5db 0%,
                    #1d466c 100%
                );
                background: -o-linear-gradient(
                    bottom left,
                    #92b5db 0%,
                    #1d466c 100%
                );
                background: linear-gradient(
                    to top right,
                    #92b5db 0%,
                    #1d466c 100%
                );
            }

            .input-form {
                max-width: 680px;

                margin-top: 80px;
                padding: 32px;

                background: #fff;
                -webkit-border-radius: 10px;
                -moz-border-radius: 10px;
                border-radius: 10px;
                -webkit-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
                -moz-box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
                box-shadow: 0 8px 20px 0 rgba(0, 0, 0, 0.15);
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="input-form-backgroud row">
                <div class="input-form col-md-12 mx-auto">
                    <h4 class="mb-3">운동영상 리뷰</h4>
                    <form class="validation-form" novalidate>
                        <form action="review" method="POST">
                        <input type="hidden" name="act" value="update"> 
		<input type="hidden" name="id" value="${review.id}"> 
                            <div class="form-group">
                                <input
                                    type="text"
                                    name="title" value="${review.title }"
                                    class="form-control"
                                    
                                    aria-describedby="emailHelp"
                                    
                                />
                            </div>
                            <br/>
                            
                             <div class="form-group">
                                <input
                                    type="text"
                                    name="writer" readonly value="${review.writer }"
                                    class="form-control"
                                    
                                    aria-describedby="emailHelp"
                                    
                                />
                            </div>
                            <br/>

                            <div class="form-group">
                                <input
                                    type="text"
                                    name="content"  value="${review.content }"
                                    class="form-control"
                                    
                                    aria-describedby="emailHelp"
                                    
                                />
                            </div>

                            <br />
                            <button
       
                                class="btn btn-outline-primary"
                                onclick="location.href='review?act=update'"
                            >
                                수정
                            </button>
                            </form>
                            <button
                                type="button"
                                class="btn btn-outline-danger"
                                onclick="location.href='review?act=list'"
                            >
                                취소
                            </button>
                        
                    </form>
                </div>
            </div>
        </div>
        <script>
            window.addEventListener(
                "load",
                () => {
                    const forms =
                        document.getElementsByClassName("validation-form");

                    Array.prototype.filter.call(forms, (form) => {
                        form.addEventListener(
                            "submit",
                            function (event) {
                                if (form.checkValidity() === false) {
                                    event.preventDefault();
                                    event.stopPropagation();
                                }

                                form.classList.add("was-validated");
                            },
                            false
                        );
                    });
                },
                false
            );
        </script>
    </body>
</html>

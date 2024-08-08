function select(num, gameId, userId) {
    if (!confirm(num + "번으로 선택하시겠습니까?")) {
        return false;
    }

    if (isPrincipalEmpty) {
        alert("로그인 하세요");
        return false;
    }

    if (isGamePlay) {
        alert("이미 마감된 게임입니다");
        return false;
    }

    checkDuplication(num, gameId, userId);
}

function checkDuplication(num, gameId, userId) {
    $.ajax({
        url: "/check/duplication",
        type: "POST",
        data: {
            gameId : gameId,
            userId : userId
        },
        success:function (data){
            if(data == true){
                submitSelect(num,gameId,userId);
            }
            else{
                alert("이미 선택했습니다");
            }
        }
    })
}

function submitSelect(num, gameId, userId) {
    $.ajax({
        url: "/board/table",
        type: "POST",
        data: {
            num: num,
            gameId: gameId,
            userId: userId
        },
    }).done(function (resp) {
        alert("성공하였습니다");
    }).fail(function (resp) {
        alert("실패하였습니다");
    });
}
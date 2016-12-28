 console.log('test');
 $('#bookinsertbtn').click(function() {
        console.log('test');
        $('#bookinsertbtnDiv').css({
            'display': 'block'
        });
        $('#findBookDiv').css({
            'display': 'none'
        });
        $('#bookresultbtnDiv').css({
            'display': 'none'
        });
        $('#bookdeletebtnDiv').css({
            'display': 'none'
        });
        $('.message').css('display','none');
    });

    $('#bookcheckbtn').click(function() {
        $('#findBookDiv').css({
            'display': 'block'
        });
        $('#bookinsertbtnDiv').css({
            'display': 'none'
        });
        $('#bookdeletebtnDiv').css({
            'display': 'none'
        });
        $('#bookresultbtnDiv').css({
            'display': 'none'
        });
        $('.message').css('display','none');
    });

    $('#bookmodifybtn').click(function() {
        console.log('test');
        $('#bookinsertbtnDiv').css({
            'display': 'none'
        });
        $('#findBookDiv').css({
            'display': 'none'
        });
        $('#bookresultbtnDiv').css({
            'display': 'block'
        });
        $('#bookdeletebtnDiv').css({
            'display': 'none'
        });
        $('.message').css('display','none');
    });

    $('#bookdeletebtn').click(function() {
        console.log('test');
        $('#bookinsertbtnDiv').css({
            'display': 'none'
        });
        $('#findBookDiv').css({
            'display': 'none'
        });
        $('#bookresultbtnDiv').css({
            'display': 'none'
        });
        $('#bookdeletebtnDiv').css({
            'display': 'block'
        });
        $('.message').css('display','none');

    });
    $('#bookResult').click(function () {
        $('#bookinsertbtnDiv').css({
            'display': 'none'
        });
        $('#findBookDiv').css({
            'display': 'none'
        });
        $('#bookresultbtnDiv').css({
            'display': 'none'
        });
        $('#bookdeletebtnDiv').css({
            'display': 'none'
        });
        $('.message').css('display','none');
        $('#bookmodifybtnDiv').css('display','block');
    });
$(document).ready(
    function() {
    $('#refreshCards').click(function(event) {
        event.preventDefault();
        ajaxPost();
    });

    function ajaxPost() {

        $.ajax({
            type: 'GET',
            url: window.location.href + '/cards',
            success: function(result) {
                if(result.status == 'success') {
                    $('#cardsBlock').empty()
                    $.each(result.data, function(i, card) {
                        var packVar = $('<p>Name: ' + card.name + ', front side: ' + card.frontSide + ', back side: ' + card.backSide +'</p>');
                        $('#cardsBlock').append(packVar);
                    });
                } else {
                $('#cardsBlock').html(
                                        'Get не successfully'
                                    );
                }
                console.log(result);
            },
            error: function(e) {
                alert('error');
                console.log('ERROR: ' + e );
            }
        });
    }
});
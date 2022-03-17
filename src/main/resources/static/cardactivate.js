$(document).ready(function(){
    $('#cardsTable').on('click', 'tr', function (event) {
       activateCard(event.target);
    });
})

function activateCard(target) {
    var targetRow = $(target).closest('tr');
    var activeRow =     '<tr>'+
                            '<td hidden="true">' +
                                '<input id = "editCardId">' +
                                     targetRow.children('td.1').val() +
                                '</input>' +
                            '</td>' +
                            '<td>' +
                                '<input id = "editCardName">' +
                                    targetRow.children('td.2').val() +
                                '</input>' +
                            '</td>' +
                            '<td>' +
                                '<input id = "editCardFrontSide">' +
                                     targetRow.children('td.3').val() +
                                '</input>' +
                            '</td>' +
                            '<td>' +
                                '<input id = "editCardBackSide">' +
                                     targetRow.children('td.4').val() +
                                '</input>' +
                            '</td>' +
                        '</tr>';
    targetRow.replaceWith($(activeRow));
}
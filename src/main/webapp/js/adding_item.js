$(function () {
    $('.card__button-btn').click(function () { likeFunction(this); });
    $('.card__button').click(function () { dislikeFunction(this);});
});


function likeFunction(caller) {

    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "cartFunction?action=LIKE&itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        success: function () {
            console.log(itemId);
            console.log(typeCategory);
        }
    });
}
function dislikeFunction(caller) {

    var ITEM_ID = caller.parentElement.getAttribute('itemId');
    var TYPE_CATEGORY = caller.parentElement.getAttribute('categoryType');

    $.ajax({
        type: "POST",
        url: "cartFunction?action=DISLIKE&itemId=" + ITEM_ID + "&categoryType=" + TYPE_CATEGORY,
        data: {
            itemId: ITEM_ID,
            typeCategory: TYPE_CATEGORY
        },
        success: function () {
            console.log(itemId);
            console.log(typeCategory);
        }
    });
}
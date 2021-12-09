/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//atribuindo propriedade hover com JS
 
function btnClick(btnName){
    var btn=document.querySelector("input[name='"+btnName+"']");
    var btns=document.querySelectorAll("input[type='button']");
    var lbs=document.querySelectorAll("#menu  > .input >.icon");
    for(var i=0;i<btns.length;i++){
        btns[i].style.background='none';
        lbs[i].style.background='none';
    }
    btn.style.background='orange';
    if(btnName==="garson"){
        garson();
    }else if(btnName==="user"){
        usuario();
    }else if(btnName==="rPed"){
        registarPedido();
    }else if(btnName==="vPed"){
        verificarPedido();
    }else if(btnName==="vCont"){
        verificarContas();
    }else if(btnName==="vProd"){
        verificarProdutos();
    }else if(btnName==="fLog"){
        fazerLogout();
    }
}

function btnHoverIn(btn){
    if(btn.style.background!=='orange'){
        btn.style.background='gray';
    }
}
function btnHoverOut(btn){
    if(btn.style.background!=='orange'){
        btn.style.background='none';
    }
}

function garson(){
    var div=document.getElementById("vgarson");
    div.style.display='inherit';
    window.document.body.innerHTML+=div;
}

function usuario(){
    var div=document.getElementById("vuser");
    div.style.display='inherit';
    window.document.body.innerHTML+=div;
}
function registarPedido(){
    var div=document.getElementById("main_rPed");
    setMainInvisible(div);
}
function verificarPedido(){
    var div=document.getElementById("main_vPed");
    setMainInvisible(div);
}
function verificarContas(){
    var div=document.getElementById("main_vCont");
    setMainInvisible(div);;
}
function verificarProdutos(){
    var div=document.getElementById("main_vProd");
    setMainInvisible(div);
}
function fazerLogout(){
    var div=document.getElementById("vlogout");
    div.style.display='inherit';
    window.document.body.innerHTML+=div;
}
function setMainInvisible(main){
    var mains=document.getElementsByClassName("mainbody");
    for(var i=0;i<mains.length;i++){
        mains[i].style.display='none';
    }
    main.style.display='inherit';
}

function userCancel(){
    var btn=document.querySelector("#btn_u");
    btn.style.background='none';
    var div=document.getElementById("vuser");
    div.style.display='none';
}
function garsonCancel(){
    var btn=document.querySelector("#btn_g");
    btn.style.background='none';
    var div=document.getElementById("vgarson");
    div.style.display='none';
}
function logoutCancel(){
    var btn=document.querySelector("#btn_log");
    btn.style.background='none';
    var div=document.getElementById("vlogout");
    div.style.display='none';
}

function rPedido(div_id,btn){
    var div=document.getElementById(div_id);
    div.style.display='inherit';
}
function rPedidoX(div_id){
    var div=document.getElementById(div_id);
    div.style.display='none'; 
}
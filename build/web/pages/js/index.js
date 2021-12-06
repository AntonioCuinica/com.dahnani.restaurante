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
    
}

function usuario(){
    
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
  
}
function setMainInvisible(main){
    var mains=document.getElementsByClassName("mainbody");
    for(var i=0;i<mains.length;i++){
        mains[i].style.display='none';
    }
    main.style.display='inherit';
}


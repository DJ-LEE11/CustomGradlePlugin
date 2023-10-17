System.register("chunks:///_virtual/BgControl.ts",["./rollupPluginModLoBabelHelpers.js","cc","./EnemyControl.ts","./BulletControl.ts"],(function(t){var o,n,e,r,i,s,c,a,l;return{setters:[function(t){o=t.inheritsLoose,n=t.createForOfIteratorHelperLoose},function(t){e=t.cclegacy,r=t._decorator,i=t.PhysicsSystem2D,s=t.Contact2DType,c=t.Component},function(t){a=t.EnemyControl},function(t){l=t.BulletControl}],execute:function(){var u;e._RF.push({},"8cb34iYscFKuY3SMK/laBjr","BgControl",void 0);var p=r.ccclass;r.property,t("BgControl",p("BgControl")(u=function(t){function e(){return t.apply(this,arguments)||this}o(e,t);var r=e.prototype;return r.start=function(){i.instance.on(s.BEGIN_CONTACT,this.onBeginContact,this)},r.onBeginContact=function(t,o){1===o.tag&&0===t.tag?(o.getComponent(a).die(),t.getComponent(l).die()):0===o.tag&&1===t.tag&&(o.getComponent(l).die(),t.getComponent(a).die())},r.update=function(t){for(var o,e=n(this.node.children);!(o=e()).done;){var r=o.value,i=r.getPosition(),s=i.x,c=i.y-100*t;r.setPosition(s,c),c<-870&&r.setPosition(s,c+1704)}},e}(c))||u);e._RF.pop()}}}));

System.register("chunks:///_virtual/BulletControl.ts",["./rollupPluginModLoBabelHelpers.js","cc"],(function(t){var o,e,n,r;return{setters:[function(t){o=t.inheritsLoose},function(t){e=t.cclegacy,n=t._decorator,r=t.Component}],execute:function(){var i;e._RF.push({},"07886v0c61NRJcFV7W48jF5","BulletControl",void 0);var s=n.ccclass;n.property,t("BulletControl",s("BulletControl")(i=function(t){function e(){for(var o,e=arguments.length,n=new Array(e),r=0;r<e;r++)n[r]=arguments[r];return(o=t.call.apply(t,[this].concat(n))||this).isDead=!1,o}o(e,t);var n=e.prototype;return n.start=function(){},n.update=function(t){var o=this.node.getPosition(),e=o.x,n=o.y+600*t;this.node.setPosition(e,n),n>800&&this.node.destroy()},n.die=function(){var t=this;this.isDead||(this.isDead=!0,setTimeout((function(){var o;null==(o=t.node)||null==o.destroy||o.destroy()}),10))},e}(r))||i);e._RF.pop()}}}));

System.register("chunks:///_virtual/debug-view-runtime-control.ts",["./rollupPluginModLoBabelHelpers.js","cc"],(function(t){var e,o,i,n,s,l,r,a,g,h,p,c,C,d,m,u,L;return{setters:[function(t){e=t.applyDecoratedDescriptor,o=t.inheritsLoose,i=t.initializerDefineProperty,n=t.assertThisInitialized},function(t){s=t.cclegacy,l=t._decorator,r=t.Node,a=t.Color,g=t.Canvas,h=t.UITransform,p=t.instantiate,c=t.Label,C=t.RichText,d=t.Toggle,m=t.Button,u=t.director,L=t.Component}],execute:function(){var f,M,b,v,T,S,x,E,I;s._RF.push({},"b2bd1+njXxJxaFY3ymm06WU","debug-view-runtime-control",void 0);var A=l.ccclass,y=l.property;t("DebugViewRuntimeControl",(f=A("internal.DebugViewRuntimeControl"),M=y(r),b=y(r),v=y(r),f((x=e((S=function(t){function e(){for(var e,o=arguments.length,s=new Array(o),l=0;l<o;l++)s[l]=arguments[l];return e=t.call.apply(t,[this].concat(s))||this,i(e,"compositeModeToggle",x,n(e)),i(e,"singleModeToggle",E,n(e)),i(e,"EnableAllCompositeModeButton",I,n(e)),e._single=0,e.strSingle=["No Single Debug","Vertex Color","Vertex Normal","Vertex Tangent","World Position","Vertex Mirror","Face Side","UV0","UV1","UV Lightmap","Project Depth","Linear Depth","Fragment Normal","Fragment Tangent","Fragment Binormal","Base Color","Diffuse Color","Specular Color","Transparency","Metallic","Roughness","Specular Intensity","IOR","Direct Diffuse","Direct Specular","Direct All","Env Diffuse","Env Specular","Env All","Emissive","Light Map","Shadow","AO","Fresnel","Direct Transmit Diffuse","Direct Transmit Specular","Env Transmit Diffuse","Env Transmit Specular","Transmit All","Direct Internal Specular","Env Internal Specular","Internal All","Fog"],e.strComposite=["Direct Diffuse","Direct Specular","Env Diffuse","Env Specular","Emissive","Light Map","Shadow","AO","Normal Map","Fog","Tone Mapping","Gamma Correction","Fresnel","Transmit Diffuse","Transmit Specular","Internal Specular","TT"],e.strMisc=["CSM Layer Coloration","Lighting With Albedo"],e.compositeModeToggleList=[],e.singleModeToggleList=[],e.miscModeToggleList=[],e.textComponentList=[],e.labelComponentList=[],e.textContentList=[],e.hideButtonLabel=void 0,e._currentColorIndex=0,e.strColor=["<color=#ffffff>","<color=#000000>","<color=#ff0000>","<color=#00ff00>","<color=#0000ff>"],e.color=[a.WHITE,a.BLACK,a.RED,a.GREEN,a.BLUE],e}o(e,t);var s=e.prototype;return s.start=function(){if(this.node.parent.getComponent(g)){var t=this.node.parent.getComponent(h),e=.5*t.width,o=.5*t.height,i=.1*e-e,n=o-.1*o,s=this.node.getChildByName("MiscMode"),l=p(s);l.parent=this.node,l.name="Buttons";var r=p(s);r.parent=this.node,r.name="Titles";for(var u=0;u<2;u++){var L=p(this.EnableAllCompositeModeButton.getChildByName("Label"));L.setPosition(i+(u>0?450:150),n,0),L.setScale(.75,.75,.75),L.parent=r;var f=L.getComponent(c);f.string=u?"----------Composite Mode----------":"----------Single Mode----------",f.color=a.WHITE,f.overflow=0,this.labelComponentList[this.labelComponentList.length]=f}n-=20;for(var M=0,b=0;b<this.strSingle.length;b++,M++){b===this.strSingle.length>>1&&(i+=200,M=0);var v=b?p(this.singleModeToggle):this.singleModeToggle;v.setPosition(i,n-20*M,0),v.setScale(.5,.5,.5),v.parent=this.singleModeToggle.parent;var T=v.getComponentInChildren(C);T.string=this.strSingle[b],this.textComponentList[this.textComponentList.length]=T,this.textContentList[this.textContentList.length]=T.string,v.on(d.EventType.TOGGLE,this.toggleSingleMode,this),this.singleModeToggleList[b]=v}i+=200,this.EnableAllCompositeModeButton.setPosition(i+15,n,0),this.EnableAllCompositeModeButton.setScale(.5,.5,.5),this.EnableAllCompositeModeButton.on(m.EventType.CLICK,this.enableAllCompositeMode,this),this.EnableAllCompositeModeButton.parent=l;var S=this.EnableAllCompositeModeButton.getComponentInChildren(c);this.labelComponentList[this.labelComponentList.length]=S;var x=p(this.EnableAllCompositeModeButton);x.setPosition(i+90,n,0),x.setScale(.5,.5,.5),x.on(m.EventType.CLICK,this.changeTextColor,this),x.parent=l,(S=x.getComponentInChildren(c)).string="TextColor",this.labelComponentList[this.labelComponentList.length]=S;var E=p(this.EnableAllCompositeModeButton);E.setPosition(i+200,n,0),E.setScale(.5,.5,.5),E.on(m.EventType.CLICK,this.hideUI,this),E.parent=this.node.parent,(S=E.getComponentInChildren(c)).string="Hide UI",this.labelComponentList[this.labelComponentList.length]=S,this.hideButtonLabel=S,n-=40;for(var I=0;I<this.strMisc.length;I++){var A=p(this.compositeModeToggle);A.setPosition(i,n-20*I,0),A.setScale(.5,.5,.5),A.parent=s;var y=A.getComponentInChildren(C);y.string=this.strMisc[I],this.textComponentList[this.textComponentList.length]=y,this.textContentList[this.textContentList.length]=y.string,A.getComponent(d).isChecked=!!I,A.on(d.EventType.TOGGLE,I?this.toggleLightingWithAlbedo:this.toggleCSMColoration,this),this.miscModeToggleList[I]=A}n-=150;for(var D=0;D<this.strComposite.length;D++){var B=D?p(this.compositeModeToggle):this.compositeModeToggle;B.setPosition(i,n-20*D,0),B.setScale(.5,.5,.5),B.parent=this.compositeModeToggle.parent;var w=B.getComponentInChildren(C);w.string=this.strComposite[D],this.textComponentList[this.textComponentList.length]=w,this.textContentList[this.textContentList.length]=w.string,B.on(d.EventType.TOGGLE,this.toggleCompositeMode,this),this.compositeModeToggleList[D]=B}}else console.error("debug-view-runtime-control should be child of Canvas")},s.isTextMatched=function(t,e){var o=new String(t),i=o.search(">");return-1===i?t===e:(o=(o=o.substr(i+1)).substr(0,o.search("<")))===e},s.toggleSingleMode=function(t){for(var e=u.root.debugView,o=t.getComponentInChildren(C),i=0;i<this.strSingle.length;i++)this.isTextMatched(o.string,this.strSingle[i])&&(e.singleMode=i)},s.toggleCompositeMode=function(t){for(var e=u.root.debugView,o=t.getComponentInChildren(C),i=0;i<this.strComposite.length;i++)this.isTextMatched(o.string,this.strComposite[i])&&e.enableCompositeMode(i,t.isChecked)},s.toggleLightingWithAlbedo=function(t){u.root.debugView.lightingWithAlbedo=t.isChecked},s.toggleCSMColoration=function(t){u.root.debugView.csmLayerColoration=t.isChecked},s.enableAllCompositeMode=function(t){var e=u.root.debugView;e.enableAllCompositeMode(!0);for(var o=0;o<this.compositeModeToggleList.length;o++){this.compositeModeToggleList[o].getComponent(d).isChecked=!0}var i=this.miscModeToggleList[0].getComponent(d);i.isChecked=!1,e.csmLayerColoration=!1,(i=this.miscModeToggleList[1].getComponent(d)).isChecked=!0,e.lightingWithAlbedo=!0},s.hideUI=function(t){var e=this.node.getChildByName("Titles"),o=!e.active;this.singleModeToggleList[0].parent.active=o,this.miscModeToggleList[0].parent.active=o,this.compositeModeToggleList[0].parent.active=o,this.EnableAllCompositeModeButton.parent.active=o,e.active=o,this.hideButtonLabel.string=o?"Hide UI":"Show UI"},s.changeTextColor=function(t){this._currentColorIndex++,this._currentColorIndex>=this.strColor.length&&(this._currentColorIndex=0);for(var e=0;e<this.textComponentList.length;e++)this.textComponentList[e].string=this.strColor[this._currentColorIndex]+this.textContentList[e]+"</color>";for(var o=0;o<this.labelComponentList.length;o++)this.labelComponentList[o].color=this.color[this._currentColorIndex]},s.onLoad=function(){},s.update=function(t){},e}(L)).prototype,"compositeModeToggle",[M],{configurable:!0,enumerable:!0,writable:!0,initializer:function(){return null}}),E=e(S.prototype,"singleModeToggle",[b],{configurable:!0,enumerable:!0,writable:!0,initializer:function(){return null}}),I=e(S.prototype,"EnableAllCompositeModeButton",[v],{configurable:!0,enumerable:!0,writable:!0,initializer:function(){return null}}),T=S))||T));s._RF.pop()}}}));

System.register("chunks:///_virtual/EnemyControl.ts",["./rollupPluginModLoBabelHelpers.js","cc"],(function(e){var t,n,o,i,a,r,s;return{setters:[function(e){t=e.inheritsLoose},function(e){n=e.cclegacy,o=e._decorator,i=e.resources,a=e.SpriteFrame,r=e.Sprite,s=e.Component}],execute:function(){var u;n._RF.push({},"4e9a1LOoCxABJ1uxzbIzOUo","EnemyControl",void 0);var c=o.ccclass;o.property,e("EnemyControl",c("EnemyControl")(u=function(e){function n(){for(var t,n=arguments.length,o=new Array(n),i=0;i<n;i++)o[i]=arguments[i];return(t=e.call.apply(e,[this].concat(o))||this).isDead=!1,t.airplaneDeadImages=[],t}t(n,e);var o=n.prototype;return o.start=function(){this.loadImages()},o.update=function(e){if(!this.isDead){var t=this.node.getPosition(),n=t.x,o=t.y-500*e;this.node.setPosition(n,o),o<-900&&this.node.destroy()}},o.loadImages=function(){var e=this;i.loadDir("enemy-death",a,(function(t,n){e.airplaneDeadImages=n}))},o.playDead=function(){for(var e=this,t=function(t){setTimeout((function(){e.node.getComponent&&(e.node.getComponent(r).spriteFrame=e.airplaneDeadImages[t])}),80*t)},n=0;this.airplaneDeadImages.length,n++;)t(n)},o.die=function(){var e=this;this.isDead||(this.isDead=!0,this.playDead(),setTimeout((function(){var t;null==(t=e.node)||null==t.destroy||t.destroy()}),300))},n}(s))||u);n._RF.pop()}}}));

System.register("chunks:///_virtual/EnemyManager.ts",["./rollupPluginModLoBabelHelpers.js","cc"],(function(e){var n,t,r,i,a,o,c,s,u;return{setters:[function(e){n=e.applyDecoratedDescriptor,t=e.inheritsLoose,r=e.initializerDefineProperty,i=e.assertThisInitialized},function(e){a=e.cclegacy,o=e._decorator,c=e.Prefab,s=e.instantiate,u=e.Component}],execute:function(){var l,p,y,f,d;a._RF.push({},"7ec61wgyI5JfJKWCqVaJmux","EnemyManager",void 0);var h=o.ccclass,m=o.property;e("EnemyManager",(l=h("EnemyManager"),p=m(c),l((d=n((f=function(e){function n(){for(var n,t=arguments.length,a=new Array(t),o=0;o<t;o++)a[o]=arguments[o];return n=e.call.apply(e,[this].concat(a))||this,r(n,"enemy",d,i(n)),n}t(n,e);var a=n.prototype;return a.start=function(){var e=this,n=this.node.getPosition(),t=(n.x,n.y);this.schedule((function(){var n=s(e.enemy);n.setPosition(400*Math.random()+40,t),e.node.addChild(n)}),.5)},a.update=function(e){},n}(u)).prototype,"enemy",[p],{configurable:!0,enumerable:!0,writable:!0,initializer:null}),y=f))||y));a._RF.pop()}}}));

System.register("chunks:///_virtual/main",["./debug-view-runtime-control.ts","./BgControl.ts","./BulletControl.ts","./EnemyControl.ts","./EnemyManager.ts","./PlayerControl.ts"],(function(){return{setters:[null,null,null,null,null,null],execute:function(){}}}));

System.register("chunks:///_virtual/PlayerControl.ts",["./rollupPluginModLoBabelHelpers.js","cc"],(function(t){var e,n,o,r,i,a,l,s,c,u,p,d;return{setters:[function(t){e=t.applyDecoratedDescriptor,n=t.inheritsLoose,o=t.initializerDefineProperty,r=t.assertThisInitialized},function(t){i=t.cclegacy,a=t._decorator,l=t.Prefab,s=t.Node,c=t.v3,u=t.director,p=t.instantiate,d=t.Component}],execute:function(){var y,f,h,v,P;i._RF.push({},"04843wcogRHA7jFQFP4lMGI","PlayerControl",void 0);var g=a.ccclass,b=a.property;t("PlayerControl",(y=g("PlayerControl"),f=b(l),y((P=e((v=function(t){function e(){for(var e,n=arguments.length,i=new Array(n),a=0;a<n;a++)i[a]=arguments[a];return e=t.call.apply(t,[this].concat(i))||this,o(e,"bullet",P,r(e)),e}n(e,t);var i=e.prototype;return i.start=function(){var t=this;this.node.on(s.EventType.TOUCH_MOVE,(function(e){var n=e.getUILocation(),o=n.x,r=n.y;t.node.setWorldPosition(c(o,r))})),this.schedule((function(){var e=t.node.getPosition(),n=e.x,o=e.y,r=u.getScene().getChildByName("Canvas"),i=p(t.bullet);i.setPosition(n,o+70),r.addChild(i)}),.2),this.schedule((function(){var e=t.node.getPosition(),n=e.x,o=e.y,r=p(t.bullet);r.setParent(t.node.parent),r.setPosition(n,o+70)}),.2)},i.update=function(t){},e}(d)).prototype,"bullet",[f],{configurable:!0,enumerable:!0,writable:!0,initializer:function(){return null}}),h=v))||h));i._RF.pop()}}}));

(function(r) {
  r('virtual:///prerequisite-imports/main', 'chunks:///_virtual/main'); 
})(function(mid, cid) {
    System.register(mid, [cid], function (_export, _context) {
    return {
        setters: [function(_m) {
            var _exportObj = {};

            for (var _key in _m) {
              if (_key !== "default" && _key !== "__esModule") _exportObj[_key] = _m[_key];
            }
      
            _export(_exportObj);
        }],
        execute: function () { }
    };
    });
});
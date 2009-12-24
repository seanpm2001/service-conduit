// ActionScript file
import flash.events.Event;

import mx.collections.ArrayCollection;
import mx.collections.XMLListCollection;
import mx.rpc.events.ResultEvent;

[Bindable]
private var serverUrl:String;

[Bindable]
private var xlc:XMLListCollection = new XMLListCollection();

private function retrieveInstructions():void {
	startProgressBar('Loading instructions');	
	instructionRetrievalService.send({'msgId':submissionMsgId.text})	
}

private function onInstructionRetrievalService(event:ResultEvent):void {
	stopProgressBar(event);
	var doc:XMLDocument = event.result.parentNode;
	var tmp:XML = new XML(doc.toString());		
	xlc.source = tmp.item;				
}

private function startProgressBar(text:String):void
{
	progress.label=text;;
	progress.visible=true;
}

private function stopProgressBar(event:Event):void
{
   var progressTimer:Timer = new Timer(500);
   progressTimer.addEventListener("timer", timerHandler);
   progressTimer.start();       
}

public function timerHandler(event:TimerEvent):void {
	progress.label="Done";
	progress.visible=false;
}
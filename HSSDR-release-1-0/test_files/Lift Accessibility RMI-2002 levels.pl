# Kazda winda
isLift(x)  <=> type(x)="LiftConform" or type(x)="LiftNonConform" or type(x)="LiftCargo";

#Budynek bez windy
BuildingWithoutLift()<=> not exists p in Rooms: isLift(p);
	
# Dozwolona winda
AllowedForDisabled(p) <=> type(p)="LiftConform" or 
( type(p)="LiftCargo" and not exists x in Rooms: type(x)="LiftConform" or type(x)="LiftNonConform");
 
failure_msg "brak dostepu do windy z poziomu parteru"
success_msg "dostep do windy z poziomu parteru-ok"
BuildingWithoutLift()
or
( exists lift in Rooms :AllowedForDisabled(lift)  and floorNr(lift)=0);

failure_msg "brak windy na wszystkich pietrach"
success_msg "winda na wszystkich pietrach-ok"
BuildingWithoutLift()
or 
( forall n in Floors: exists lift in Rooms:AllowedForDisabled(lift) and floorNr(lift)=n);

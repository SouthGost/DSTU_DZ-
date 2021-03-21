type
staticSegment = array[0..35] of byte;
dinamicSegment = array[0..31] of byte;
var
  stseg:staticSegment;
  dinseg:array[0..3] of dinamicSegment;

procedure NewPointer(myC:char;mySize:byte);
var
  i,lastSize,lastStart,tempC,tempSize,tempStart1,tempStart2,tempC2,tempSize2,tempStart12,tempStart22:byte;
  chek:boolean;
begin
  chek:=false;
  i:=0;
  while(i<32) do
  begin
    if (Ord(myC)=stseg[i]) then 
    begin
      chek:=true;
      break;
    end;
    i+=4;
  end;
  
  if(chek=true)then
    writeln('Error: Запрешенное имя указателя!')
  else    
  begin
    
    i:=0;
    lastSize:=0;
    lastStart:=0;
    while(i<32) do
    begin
      if(lastSize<>(stseg[i+2]*32+stseg[i+3])-lastStart)then
      begin
        if(mySize<=(stseg[i+2]*32+stseg[i+3])-lastStart)then
        begin
          //
          
          tempC:=stseg[i];
          tempSize:=stseg[i+1];
          tempStart1:=stseg[i+2];
          tempStart2:=stseg[i+3];
          {
          stseg[i+4]:=stseg[i];
          stseg[i+5]:=stseg[i+1];
          stseg[i+6]:=stseg[i+2];
          stseg[i+7]:=stseg[i+3];
          }
          stseg[i]:=Ord(myC);
          stseg[i+1]:=mySize;
          stseg[i+2]:=(lastStart+lastSize)div 32;
          stseg[i+3]:=(lastStart+lastSize)mod 32;
          i+=4;
          tempC2:=1;
          while((i<32) and (tempC<>32))do
          begin
          tempC2:=stseg[i];
          tempSize2:=stseg[i+1];
          tempStart12:=stseg[i+2];
          tempStart22:=stseg[i+3];
          stseg[i]:=tempC;
          stseg[i+1]:=tempSize;
          stseg[i+2]:=tempStart1;
          stseg[i+3]:=tempStart2;
          tempC:=tempC2;
          tempSize:=tempSize2;
          tempStart1:=tempStart12;
          tempStart2:=tempStart22;
            i+=4;
            
            //
          end; 
          stseg[i]:=tempC;
          stseg[i+1]:=tempSize;
          stseg[i+2]:=tempStart1;
          stseg[i+3]:=tempStart2;
          break;
        end;
      end;
      lastSize:=stseg[i+1];
      lastStart:=stseg[i+2]*32+stseg[i+3];
      i+=4;
    end;
  end;
  //writeln(myC,' добавлен.');
end;

procedure showStSeg();
var
  i:byte;
begin
  i:=0;
  while ((i<32) and (stseg[i]<>32)) do //and (stseg[i]<>32)
  begin
    writeln(chr(stseg[i]),' ',stseg[i+1],' ',stseg[i+2],' ',stseg[i+3]);//chr(stseg[i])
    i+=4;
  end; 
end;

procedure showDinSeg();
var
  i,j:byte;
begin
  i:=0; 
  j:=0;
  while((i<4) ) do//and (dinseg[i][j]<>0)
  begin
    while((j<32) ) do//and (dinseg[i][j]<>0)
    begin      
      write(dinseg[i][j]:3,' ');
      j+=1;
    end;
    i+=1;
    j:=0;
    writeln('/');
  end;
      
end;

procedure WritePointer(myC:char;val:string);
var
  i,j,location:byte;
  chek:boolean;
begin
  chek:=false;
  i:=0;
  while(i<32) do
  begin
    if (Ord(myC)=stseg[i]) then 
    begin
      chek:=true;
      break;
    end;
    i+=4;
  end;
  if(chek=false)then
    writeln('Error: Такого указателя нет!')
  else
  begin
    if(stseg[i+1]<length(val))then
      writeln('Error: Длинна не подходит!')
    else
    begin
      location:=stseg[i+2]*32+stseg[i+3]+stseg[i+1]-1;
      j:=stseg[i+1];
      while (length(val)<>0) do
      begin
        dinseg[location div 32][location mod 32]:= ord(val[length(val)]);
        delete(val,length(val),1);
        j-=1;
        location-=1;
      end;
      while (j<>0) do
      begin
        dinseg[location div 32][location mod 32]:= 32;
        j-=1;
        location-=1;
      end;
    end;
  end;
end;  

procedure ReadPointer(myC:char);
var
  i,j,location:byte;
  chek:boolean;
begin
  chek:=false;
  i:=0;
  while(i<32) do
  begin
    if (Ord(myC)=stseg[i]) then 
    begin
      chek:=true;
      break;
    end;
    i+=4;
  end;
  if(chek=false)then
    writeln('Error: Такого указателя нет!')
  else
  begin
    location:=stseg[i+2]*32+stseg[i+3];
    for j:=0 to stseg[i+1]-1 do
    begin
      if (dinseg[location div 32][location mod 32]<>0)then
        write(chr(dinseg[location div 32][location mod 32]));
      location+=1;
    end;
    writeln();
  end;  
end;

procedure FreePointer(myC:char);
var
  i:byte;
  chek:boolean;
begin
  chek:=false;
  i:=0;
  while(i<32) do
  begin
    if (Ord(myC)=stseg[i]) then 
    begin
      chek:=true;
      break;
    end;
    i+=4;
  end;
  if(chek=false)then
    writeln('Error: Такого указателя нет!')
  else
  begin
    for i:=i to 31 do
      stseg[i]:=stseg[i+4]; 
    writeln(myC,' deteted');  
  end;    
end;

var
size:byte;
begin
  stseg[0]:=32;
  stseg[1]:=0;
  stseg[2]:=3;
  stseg[3]:=32;
  
  NewPointer('c',4);  
  NewPointer('d',4);  
  NewPointer('a',4);  
  NewPointer('b',4);  
  NewPointer('m',4);
  NewPointer('q',4);

  showStSeg();
  
  WritePointer('c','c');
  WritePointer('d','d');
  WritePointer('a','a');
  WritePointer('b','b');
  WritePointer('m','m');
  writeln('---------------');
  ReadPointer('m');
  ReadPointer('a');
  ReadPointer('b');
  ReadPointer('c');
  ReadPointer('d');
  writeln('---------------');
  showStSeg();
  writeln('---------------');  
  //showDinSeg();
  FreePointer('c');
  showStSeg();
  writeln('---------------');  
  NewPointer('e',4);
  showStSeg();
  FreePointer('m');
  NewPointer('f',4);
  NewPointer('g',4);
  NewPointer('h',4);
  writeln('---------------');   
  showStSeg();
  WritePointer('h','help');
  ReadPointer('h');
  writeln('---------------'); 
  showStSeg();
  showDinSeg();
end.
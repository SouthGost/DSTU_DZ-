Var inf : file of integer;
i,otr:integer;
Buffer : array [1..512] of integer;

Begin
Assign(inf , './fst.txt');
rewrite(inf);
write(inf,1,2,3,4,5);
close(inf);
Reset(inf);
otr:=0;
i:=1;
While not eof(inf) do begin
  Read(inf, Buffer[i]); 
  if (Buffer[i]<0) then 
    otr+=1;
  Writeln( Buffer[i]); 
  i+=1;
End;

writeln('отрицательных - ',otr);
Close(inf);


End.
Var out : file;
i,s,bl:integer;
Buffer : array [1..512] of char;

Begin
Assign(out , './sec.txt');

Reset(out);
i:=1;
s:=Random(Filesize(out));
while(not eof(out))do begin
    read(out,Buffer[i]);
    i+=1;
end;
bl:=i;

Rewrite(out);

i:=1;
while(i<>s)do begin
  write(out,Buffer[i]);
  i+=1;
end;
  write(out,'!');
while(i<>bl)do begin
  write(out,Buffer[i]);
    i+=1;
end;
//write(Buffer);

writeln('Конец');

Close(out);


End.
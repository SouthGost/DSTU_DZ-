var
  out: text;
  i, n, d: integer;
  str, str2, str3: String;


begin
  Assign(out, './text.txt');
  
  Reset(out);
  
  i := 1;
  //writeln('введите подстроку');
  //read(str2);
  str2 := 'фыв';
  while(not eof(out)) do
  begin
    readln(out, str);
    d := 0;
    while true do
    begin
      n := Pos(str2, str);
      str3 := Copy(str, n, str2.Length);
      if(str2 = str3) then begin
        writeln('строка ', str2, ' находится в строке ', i, ', на позиции ', n + d * str2.Length);
        delete(str, n, str2.Length);
        d += 1;
      end
      else
        break;
    end;
    i += 1;
  end;
  
  writeln('Конец');
  Close(out);
  
  
end.
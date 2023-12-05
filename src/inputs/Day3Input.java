package inputs;

public class Day3Input {
	
	private Day3Input() {}
	
	//would prefer to use input file and line reader but following MVP until I run out of puzzles/have more time
		//for now, copied straight from source
	public static final String engineSchematic = """
			.....489............................152....503.........................180......200.........147.......13.......................239..........
			......*.....186.48....681...732........*..................935.........*.....................*......................512............*..874....
			..806.540......*.........*............249......904...358....*......957..867..863..........857.....264..............@....89=......97..*......
			......................793........................*...=.....142...........*..*....%...................@......+...............36.......547....
			...........=335..............906*634..932........201...157.............423..72..103.798.......732........161...............*................
			..........................*..........*....662.................88....................$..............=........................439.126...269...
			...905&...74.............795...128...872....*....*.....521.........../......806&.........456.....93..869.........168..............*.........
			........../..=662.824.........+............863..47........-.700.....437..........316..........................96.*......348*632....138.$932.
			........-..........*.......................................................465....*.........243......&........*...94..+..........*..........
			..41...532.......511.....-......$........&....216.................................330...715..../...309........415.....388.....873.287.265...
			....*...................338...496.......18......*............48........873................@.............493.................................
			..849.............................136.#......787.........787..$....152..*........187..../.....738......*....................&85..960...749..
			..............395.................*...478...........................*....860.......*...613./.........194........................*.....%.....
			.....+799.........132..188........691..........689/...176..........274........569..840.....8....#........................451...71...........
			..............93..&....*........@........#..................892..............................275.....862*180../.....355..*.............796..
			.......400......*......676.....342.......930...389...925.......*...........580..3......395....................27....*....888..........#.....
			.....%......205..888................60...........=..*.......540........742.*..........*.......858..................589.......679..490.......
			...462..125*....................691..@.221=.........28...................*..31.615..827..............876...................-.........*762...
			.............501............$..=...............*.........&.............842......@.......308................601...........546................
			......428...*.............417.....760....25.....809......119.......................589.../.........610......../..%256...................858.
			......*...623...186................*......*..........895.......................$......#...........@...................337........285........
			....626.#......@.....787.....#...........294./..........*........619..........902........924....................665..*.............*........
			.........406...............10......+..........985...+....944.....*........296................169....@....686......*..............290..767...
			.......................738..........977....*.......873.......665.381..17....%.....246....576..*...861...*.......104.....208..........=......
			.919............#...............973.....320.529................*......*.......676*.............89.......112............-....988.........858.
			....*....431..63..-646.........*........................863.649..494..896.......................................759..........+..............
			...331.....*.........../969....571.........355............*.....-.........#.....804@........-......................*...875......68..........
			........558..412.............................*....758..272..............207..............466..........245.......664...@...........*..447....
			...............*..-368.......................345./.........%..@....450..........................175......*.%...............106...44.@.......
			........*290...........10...323..........................318..664...+..470....-...@...../718.......$...986..571.............*...............
			.....148......387/.....%...=....287........=784.........................*..580....260...............................440....377..-......316..
			................................&........................$....../840....................708......../.......149..................849.........
			....613..........926.......-......951....*.......185..62..265...........................-....@783...479........531..................302.....
			.89...&.....237.........949...........561.211...*......*......689...&.......@..412.......................214......*.........334.590....*908.
			...*......../.....454........245.781.............649.489..560...-..109.....27....*.........511..............*....567....495*......*./.......
			..502...36....285...#.441...+.......*.....................&............246...........@.....*...........-929.165.................338..581....
			.......+.................*......324..846..................................=....974...979..778....981...................174.811*.............
			...............*........752.701..*............76.....985.....@...588.&278..........................-................=./........720....371...
			....319.606...566..../........+...63..........*........=....543...$..............................%.............3..64........................
			......$............472..................107.129............................818........&724....454..378..........#....978.........210@.......
			..............................*295......*.......................803*143.......*.......................*.................*395.............489
			...........974...959=......772.........646..........752....=.................165.........+...305.......331..............................*...
			..243%........*.......169/.........66......#............554.............@..............48...................616....981..117........113.45...
			...........694....685......312......*.......94......840.........487.....519.655......................$365..*............*............*......
			........#......#....*..............541.960.............*..........*............-....758*...................636.......868...............%....
			.........400....538..454.@............../......138....402.....775.959...................210.990......%...................338*33.......585...
			....891...................278........*........*................*...........=................-...997.43....@.................................
			...................................76.182..775...107..........536.......302.......982.883......$.......650..........470...988...............
			...810.......694....757*842.........................*..................................-.......................956.....*.....*173...........
			............................223......212..427......748...593......554*528...462...........-.....569........67.....*....620..................
			.....349.....461....=........*.../....=......%.673.....#....*560........................694.534.*.........=......661............326...123...
			.879.#.......*....610...#.357..398.............*....933.............555.........45*..........*............................477....*.....*....
			...*.....12..240......164.............862.......17...........650...................627...40.347...640........448.#583.340.......253.918.....
			...913....*......425@......492=....&....-...931.............=....220..........................................+............288..............
			.........999....................447.........*.....222...360.............124-........+....................596........574...........233*543...
			..............234...215..793.............492.......#......%.=....255.........613...75.............754....../...........=......./............
			..............*....#.........................52.............226....*....750..............631....@.............678..............671...741....
			..298-...5..158...........%307......+........+........165*..........836....$............*.......159..938.......*...%.....644................
			....................................839...................131..................+.......210..872.........*...121..818.....*....252.........99
			......139.....609...............................%...720..................607=...407.........*...........962..............395.........359....
			.989..*..........-..........-....506....359..465......*........*288..........................324...368#.....%..602..551..................922
			.....282.................989....*......*.........52....818..834........693.689.............................845.#.......*......158...&.......
			.../.....357....410....*.....128.....153........*.....................*......*.....................656.915............267....*......234.155.
			229........*......+...488..&....................689.....71.....331..209.....521..305..365.95..........*......................35.........=...
			............355...........126.794*599.....................*....../..................$.......&.328...........659.........527.....252.........
			.869................675....................923@......*.....293.=.....342..............466........*.........*...................-....&857....
			...................*.............364..............827.191.......631..*......=......@..............492....615...............921..............
			............172..124...142.966........*591..........................337....852....103..*275...+..............................*.........647..
			.....233....*..........*...........172.................276...672............................132.....&............764*607...693...411........
			.......*..919...301.563.................71../......73...*..../.........170......973..74*............474............................/........
			647.405.................321.479...........*.980......*....................*.............563..877...........934.......449..701-..............
			...........................*............555...........727........328.......521...................#562........*..357.=..........893..........
			611..561......400..............&...........................700.....................570.494....63............165..=.....481......*...........
			...*.*..........=.525......317.277...............738*596......*139....528...@475....*....*......*.........*............*.........62.........
			186..149..........*.../...............357...504*....................=....*........212.....235....125...173.253..../.....992.975*............
			..........430...770....20....865......*.........705....904..-........941..216.....................................275...........763.405.....
			.........&.........................362......#..........*.....646................258.....898....241....................*..............*......
			....13.....510...935...........367..........546....98.869........217.....................*....*....431...566.........152..............69....
			...%................*.......$...-.......213.......*.........%..........683............#..265................../866...............161........
			.........962...938...259..290......177....=.......948........582........+..843.......584.........%680..782%................./437........657.
			797/.388*........*..................*........627.........................../.............897..........................@.................*...
			.................848......-..724....76.........&..........228.335...912*.................*................122.......149..828..........289...
			.......................748..*.........................722.......$.....................774...431&.........................*....739..=........
			...80...935.*621.............57......#...........484...$.......................380.72............599%..670.............233......*..26.......
			.........+........................812...$..........*...............259*470......*...%..408..............*..251....618........356............
			...............*381...726...............972.109..260.....934.%878................92.....*...760......926..*..........*66....................
			..703.......592............384.......................433..=..................814......764........809......636...534...........$.......944...
			.....*..275.....................83.........623...695..*............516..30.....$.................&...............*.............507....*.....
			...254...*......#...74............%.............*....496.9.........*........................727....335...662......473...530$..........942...
			.......420.......66.*....679.332@...413..........417......*..188.609....908......*587........%........&.....&.411...............640.........
			...382.....462......871...*.............951...............25..............-...860................604............*....699..814....*..........
			....&.......#..............574........................................................503.723*......$.....-...527...*.......*.683....249.395
			..............781............................21.....721*206.990.97...............87...........971......273..........951..736........*.......
			.............*..........948..808..158..........%...............*................&......*537.......................=............-....529.....
			164*....18..753............/..*............................96.......................316........382........946...685.........455.............
			....672...........*205.........695...........................$...279....#625....138..................115....*.........566..........410......
			...............605.....17.............705..$177.......424...........*.........................737......*...297...........-..................
			..780..............858*........24.......$.............*.......+......432.........................*....406......137..779*...$...695..........
			....%.%192..........................734...860.........160...562..62........362.....896%........42..............*..........265.$.............
			............107/.......719..983............*..............................%.........................................................997.....
			..........................*....*377...118...589..................926...&.......11........501.......$............490..996..*.............%...
			.........../....769........210........*................999......@.....372.11*...*.......*.....295..71......969@.-...*......223.....840..869.
			........742.....................554...148..........812....*.........+..........727....875......#........./.........857.875...........*......
			...611...........150*693...164....+........................636..327.73................................329...............*....25....747.942..
			........336...............*............808...*.....894...........*.......707*640.................538@................*...308............*...
			.........$..............#..817..424*89...&.117......../.....2..243.....................................279*143..866..458............623.170.
			.....301.......199...871..........................728......-.......742.252...876......./192........................................@........
			.......*.825..+..........284-.....271................*........418....&.......*...............+.......781-..........92#...222............%452
			....786....*.....................#.................272..................133....653.........82..................554................*156......
			............838..917-..868*492.............156...........970..............*.....*..337...............100........*..397*177.....442.....&....
			..951..........................193..........%..............*.562=......505............+....203.971...........843...........%............753.
			...*............498....754......*......562....262........668................781................*.....*621.........115.....249...............
			....470......@........*......75.227......*...*...............57+........769....+....-.......839...968.....876......*..............491.......
			..........807..297..305..883..........470...505.....245...........682......*......415....................*.........982...........&.....180..
			................*...........*.............$.........*.......205......*135.......................%.....286..............418.............$....
			....362.444.....815..........722....336...37.........283...*..............329................433..........@153..........*.....435...........
			....*......*.........237...............*.....247...........108.....906.......=......611.............................608..814.-..............
			......285.......865.*..........62.973...781.....*..982.............*......60.......$.......722......=..834.%.....85*............215.........
			........*....%.......780.996..%....*..............%..........7..855..515.+.....990........*........600...+.765............911.....*.........
			......130..932.180.......*......143.........../..............*.......*..........&..149....301................................-...77.........
			...........................272.................868............943.976................*............944.........996....71.....................
			....511...............995#..-........&.................462.............-.601...931....889.&52.............................................27
			......#...55......................807.......424..968.................738...*......$..................598-.....77...408......%.......458.....
			....................88...272*................-....../....................544.......................$.........*.........11+...313....+.......
			108............819...*.......594..883..../............215..22.....................566*799........217....197..176...721......................
			.....332.......*.....846..-.......#...157................@......454....698...622..........430........47*............................../.....
			.............194..........239..................713*331..............51*.............800.....-..600.............&479..........-........805...
			......637*.....................847...........................274.#..........594...........................533........883....722....*........
			..........61...310.12......*..........923...............174....*.299.......-................132............&.........*..........876.331.....
			...............*.....*...435.864......+.......................11.....890....................$..........%............862.....968.............
			...../......404......398..........540.....................*............$.........287....................311.....515............*............
			.....564.....................807...*...567.............985.100.....%.....................227..................$.*.........*........974.156..
			..............156.953...........$........$.....................695.329..................=.............836..176..128....864..216#....*.......
			.767-...#.......%....*741...........-169........452/............*.............+...........174.....813....*..........%..............230......
			........17...............................159..........377=....659..........725....$......*........$...971.........907.766...................
			...............408.914........788...%......@...................................660.....138....333..........48..............=380...104.......
			.............$........-......*.......480...............194..*527........*....................*...............*578..961...........*..........
			...444..428..470..........128...............684.399.....*............105.680......7*583............................*.......*....53....*.....
			.....*.*...........223..........&19..........*.....*...246.....*........................526*939..........*....33..51....403..........706....
			...832..383...287.........................216....103...........710..................958...................288...............................
""";
			
}
